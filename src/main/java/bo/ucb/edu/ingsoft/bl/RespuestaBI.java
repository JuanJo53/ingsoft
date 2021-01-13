package bo.ucb.edu.ingsoft.bl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.ucb.edu.ingsoft.dao.RespuestaDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.RespuestaRequest;
import bo.ucb.edu.ingsoft.model.Respuesta;
import bo.ucb.edu.ingsoft.model.Transaction;

@Service
public class RespuestaBI {

    private RespuestaDao respuestaDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CardBl.class);

    @Autowired
    public RespuestaBI(RespuestaDao respuestaDao, TransactionDao transactionDao) {
        this.respuestaDao = respuestaDao;
        this.transactionDao = transactionDao;
    }

    public Respuesta getCardDetails(Integer userid, Integer cardid) {
        return respuestaDao.dataRespuestaId(cardid);
    }

    //Function that gets all user certificates
    public List<Respuesta> getRespuestaBasicData(Integer userId) {
        return respuestaDao.getRespuesta(userId);
    }

    public RespuestaRequest createRespuesta(Integer userId, RespuestaRequest respuestaRequest, Transaction transaction) {


        Respuesta respuesta = new Respuesta();

        System.out.println("userId");
        System.out.println(userId);

        System.out.println("respuestaRequest.getPreguntaId()");
        System.out.println(respuestaRequest.getPreguntaId());

        respuesta.setUserId(userId);
        respuesta.setPreguntaId(respuestaRequest.getPreguntaId());
        respuesta.setRespuesta(respuestaRequest.getRespuesta());
        respuesta.setRespuestaCorrecta(respuestaRequest.getRespuestaCorrecta());
        respuesta.setStatus(1);
        respuesta.setTransaction(transaction);

        respuestaDao.newRespuesta(respuesta);
        return respuestaRequest;
    }

    public RespuestaRequest editRespuesta(RespuestaRequest respuestaRequest, Integer respuestaId, Integer userid, Transaction transaction) {
        Respuesta respuesta = new Respuesta();
        respuesta.setRespuestaId(respuestaId);
        respuesta.setRespuesta(respuestaRequest.getRespuesta());


        respuesta.setStatus(1);
        respuesta.setTransaction(transaction);
        //respuestaDao.updateRespuesta(respuesta);
        return respuestaRequest;
    }

    public Respuesta deleteCard(Integer respuestaId, Transaction transaction) {

        Respuesta respuesta = new Respuesta();


        respuesta.setRespuestaId(respuestaId);
        respuesta.setStatus(0);

        respuesta.setTransaction(transaction);
        respuestaDao.deleteRespuesta(respuesta);
        return respuesta;
    }

}
