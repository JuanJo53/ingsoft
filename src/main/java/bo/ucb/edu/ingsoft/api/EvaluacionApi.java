package bo.ucb.edu.ingsoft.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.ucb.edu.ingsoft.bl.EvaluacionBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.EvaluacionRequest;
import bo.ucb.edu.ingsoft.model.Evaluacion;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;

@RestController
@RequestMapping(value = "/evaluacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EvaluacionApi {

    private EvaluacionBl evaluacionBl;
    private TransactionBl transactionBl;

    @Autowired
    public EvaluacionApi(EvaluacionBl evaluacionBl, TransactionBl transactionBl) {
        this.evaluacionBl = evaluacionBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{proyectoId}/evaluacion",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Evaluacion> getUserEvaluacion(@PathVariable("proyectoId") Integer proyectoId, HttpServletRequest request) {
        return evaluacionBl.getEvaluacionBasicData(proyectoId);
    }

    @RequestMapping(value = "/{userid}/evaluacion/{evaluacionid}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Evaluacion getUserEvaluacionDetails(@PathVariable("userid") Integer userid,@PathVariable("evaluacionid") Integer evaluacionid, HttpServletRequest request) {
        return evaluacionBl.getEvaluacionDetails(userid,evaluacionid);
    }

    @RequestMapping(value = "/{userid}/evaluacion",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public EvaluacionRequest createEvaluacion(@PathVariable("userid") Integer userid,@RequestBody EvaluacionRequest evaluacionRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);


        EvaluacionRequest  evaluacionResponse = evaluacionBl.createEvaluacion(userid, evaluacionRequest, transaction);


        return evaluacionResponse;

    }

    @RequestMapping(value = "/{userid}/evaluacion/{evaluacionid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public EvaluacionRequest editEvaluacion(@PathVariable("userid") Integer userid,@PathVariable("evaluacionid") Integer evaluacionId, @RequestBody EvaluacionRequest evaluacionRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        EvaluacionRequest evaluacionResponse = evaluacionBl.editEvaluacion(evaluacionRequest, evaluacionId,userid, transaction);
        //CertificateRequest certificateResponse = certificateBl.createCertificate(1,certificateRequest, transaction);
        return evaluacionResponse;
    }

    @RequestMapping(value = "/{userid}/evaluacion/{evaluacionid}" ,method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Evaluacion deleteEvaluacion(@PathVariable("evaluacionid") Integer certificateId, HttpServletRequest request) {
        // Creating transaction for this operation
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        // Executing the delete function in CertificateBl
        Evaluacion evaluacionResponse=evaluacionBl.deleteEvaluacion(certificateId,transaction);
        return evaluacionResponse;
    }


}
