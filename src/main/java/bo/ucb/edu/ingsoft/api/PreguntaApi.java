package bo.ucb.edu.ingsoft.api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.ucb.edu.ingsoft.bl.CardBl;
import bo.ucb.edu.ingsoft.bl.PreguntaBI;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.dto.PreguntaRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Card;
import bo.ucb.edu.ingsoft.model.Pregunta;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/pregunta")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PreguntaApi {
    private PreguntaBI preguntaBI;
    private TransactionBl transactionBl;

    @Autowired
    public PreguntaApi(PreguntaBI preguntaBI, TransactionBl transactionBl) {
        this.preguntaBI = preguntaBI;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{proyectId}/pregunta",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pregunta> getUserPregunta(@PathVariable("proyectId") Integer proyectId, HttpServletRequest request) {
        return preguntaBI.getPreguntaBasicData(proyectId);
    }



    @RequestMapping(value = "/{userid}/pregunta",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PreguntaRequest createCard(@PathVariable("userid") Integer userid,@RequestBody PreguntaRequest preguntaRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);


        PreguntaRequest preguntaResponse = preguntaBI.createPregunta(userid, preguntaRequest, transaction);


        return preguntaResponse;

    }



}
