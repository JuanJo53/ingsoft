package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.ProjectBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/my-projects")
public class ProjectApi {

    private ProjectBl projectBl;
    private TransactionBl transactionBl;

    @Autowired

    public ProjectApi(ProjectBl projectBl, TransactionBl transactionBl) {
        this.projectBl = projectBl;
        this.transactionBl = transactionBl;
    }


    @RequestMapping(value = "/{userid}" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectRequest newproyect(@PathVariable("userid") Integer id,@RequestBody ProjectRequest projectRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        ProjectRequest projectRespont=projectBl.newproject(projectRequest,id,transaction);
        //CertificateRequest certificateResponse = certificateBl.createCertificate(1,certificateRequest, transaction);
        //
        return projectRespont;
    }

}
