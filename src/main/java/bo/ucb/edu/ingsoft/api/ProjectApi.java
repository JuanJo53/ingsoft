package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.ProjectBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Project;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/user")
public class ProjectApi {

    private ProjectBl projectBl;
    private TransactionBl transactionBl;


    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectApi.class);
    @Autowired

    public ProjectApi(ProjectBl projectBl, TransactionBl transactionBl) {
        this.projectBl = projectBl;
        this.transactionBl = transactionBl;
    }


    @RequestMapping(value = "/{userid}/projects" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectRequest newproyect(@PathVariable("userid") Integer id, @Valid @RequestBody ProjectRequest projectRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        ProjectRequest projectRespont=projectBl.newproject(projectRequest,id,transaction);
        return projectRespont;
    }


    @RequestMapping(value = "/{userid}/projects/{projectid}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectRequest editproyect(@PathVariable("projectid") Integer id,@Valid @RequestBody ProjectRequest projectRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        ProjectRequest projectRespont=projectBl.editproject(projectRequest,id,transaction);
        return projectRespont;
    }

    @RequestMapping(value = "/{userid}/projects/{projectid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Project getpryect(@PathVariable("projectid") Integer id){
        return projectBl.detailsByprojectId(id);
    }
/*
*  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Certificate getUserCertificates(HttpServletRequest request) {
        return certificateBl.getCertificateBasicData(1);
    }
* /project-feed/{userid}
* */
    @RequestMapping(value = "{userid}/project-feed" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getpryectlist(@PathVariable("userid") Integer id){
    return projectBl.listproyect();
}

    @RequestMapping(value = "/{userid}/project-feed/{projectid}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectRequest editproyect(@PathVariable("userid") Integer userid,@PathVariable("projectid") Integer id,@RequestBody ProjectRequest projectRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        ProjectRequest projectRespont=projectBl.increaseViews(projectRequest,userid,id,transaction);
        return projectRespont;
    }

    @RequestMapping(value = "/list/{userid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getpryectlistuser(@PathVariable("userid") Integer id){
        return projectBl.listproyectuser(id);
    }


    @RequestMapping(value = "/list/work_on/{userid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getpryectlistuserparticipate(@PathVariable("userid") Integer id){
        return projectBl.listproyectuserparticioate(id);
    }


    @RequestMapping(value = "/{projectid}/user-request" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> userprojetrecuest(@PathVariable("projectid") Integer id){
        return  projectBl.listUserProject(id);
    }


    @RequestMapping(value = "/{projectid}/user-members" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> userprojetparticioate(@PathVariable("projectid") Integer id){
        return  projectBl.listUserProjectparticipate(id);
    }

    @RequestMapping(value = "/{userid}/projects/{projectid}/acept" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer editproyecttoacept(@PathVariable("userid") Integer iduser,@PathVariable("projectid") Integer idproyect, HttpServletRequest request) {

        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        projectBl.editprojectrollwaitingtoacept(iduser,idproyect,transaction);
        return iduser;
    }
    @RequestMapping(value = "/{userid}/projects/{projectid}/reject" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer editproyectt(@PathVariable("userid") Integer iduser,@PathVariable("projectid") Integer idproyect, HttpServletRequest request) {
        projectBl.editprojectrollwaitingtoreject(iduser,idproyect);
        return iduser;
    }

    @RequestMapping(value = "/{userid}/projects/{projectid}/recuest" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectRequest editproyectrecuest(@PathVariable("userid") Integer iduser,@PathVariable("projectid") Integer idproyect,@RequestBody ProjectRequest projectRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        projectBl.editprojectask(iduser,idproyect,transaction);
        return projectRequest;
    }

    @RequestMapping(value = "/{userid}/projectos/{projectid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer userprojet(@PathVariable("projectid") Integer idproject,@PathVariable("userid") Integer iduser){

         return projectBl.conexion(iduser,idproject);
    }

    @RequestMapping(value = "{userid}/tag/{idtag}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getpryectlisttag(@PathVariable("userid") Integer id,@PathVariable("idtag") Integer idtag){
       LOGGER.info(idtag.toString());
        return projectBl.listproyecttag(idtag);
    }
    @RequestMapping(value = "{userid}/buscar/{buscar}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getpryectlisserche(@PathVariable("userid") Integer id,@PathVariable("buscar") String idtag){
        LOGGER.info(idtag.toString());
        String a=idtag+"%";
        return projectBl.listproyecserche(a);
    }
//listproyecserche
//listproyecttag

}