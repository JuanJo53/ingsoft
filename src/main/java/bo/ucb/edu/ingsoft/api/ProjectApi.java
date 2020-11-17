package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.ProjectBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Project;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class ProjectApi {

    private ProjectBl projectBl;
    private TransactionBl transactionBl;


    @Autowired

    public ProjectApi(ProjectBl projectBl, TransactionBl transactionBl) {
        this.projectBl = projectBl;
        this.transactionBl = transactionBl;
    }


    @RequestMapping(value = "/{userid}/projects" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectRequest newproyect(@PathVariable("userid") Integer id,@RequestBody ProjectRequest projectRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        ProjectRequest projectRespont=projectBl.newproject(projectRequest,id,transaction);
        return projectRespont;
    }


    @RequestMapping(value = "/{userid}/projects/{projectid}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectRequest editproyect(@PathVariable("projectid") Integer id,@RequestBody ProjectRequest projectRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        ProjectRequest projectRespont=projectBl.editproject(projectRequest,id,transaction);
        return projectRespont;
    }

    @RequestMapping(value = "/{userid}/projects" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Project getpryect(@PathVariable("userid") Integer id){
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

}
