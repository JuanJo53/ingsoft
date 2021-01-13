package bo.ucb.edu.ingsoft.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.ucb.edu.ingsoft.bl.RespuestaBI;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.RespuestaRequest;
import bo.ucb.edu.ingsoft.model.Respuesta;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;

@RestController
@RequestMapping(value = "/respuesta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RespuestaApi {
    private RespuestaBI respuestaBI;
    private TransactionBl transactionBl;

    @Autowired
    public RespuestaApi(RespuestaBI respuestaBI, TransactionBl transactionBl) {
        this.respuestaBI = respuestaBI;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{userid}/respuesta",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Respuesta> getUserRespuesta(@PathVariable("userid") Integer userid, HttpServletRequest request) {
        return respuestaBI.getRespuestaBasicData(userid);
    }



    @RequestMapping(value = "/{userid}/respuesta",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespuestaRequest createCard(@PathVariable("userid") Integer userid,@RequestBody RespuestaRequest respuestaRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);


        RespuestaRequest respuestaResponse = respuestaBI.createRespuesta(userid, respuestaRequest, transaction);


        return respuestaResponse;

    }


}
