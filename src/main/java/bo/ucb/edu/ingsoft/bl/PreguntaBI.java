package bo.ucb.edu.ingsoft.bl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.ucb.edu.ingsoft.dao.CardDao;
import bo.ucb.edu.ingsoft.dao.PreguntaDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.dto.PreguntaRequest;
import bo.ucb.edu.ingsoft.model.Card;
import bo.ucb.edu.ingsoft.model.Pregunta;
import bo.ucb.edu.ingsoft.model.Transaction;

@Service
public class PreguntaBI {
    private PreguntaDao preguntaDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CardBl.class);

    @Autowired
    public PreguntaBI(PreguntaDao preguntaDao, TransactionDao transactionDao) {
        this.preguntaDao = preguntaDao;
        this.transactionDao = transactionDao;
    }

    public Pregunta getCardDetails(Integer userid, Integer cardid) {
        return preguntaDao.dataPreguntaId(cardid);
    }

    //Function that gets all user certificates
    public List<Pregunta> getPreguntaBasicData(Integer proyectId) {
        return preguntaDao.getPregunta(proyectId);
    }

    public PreguntaRequest createPregunta(Integer userId, PreguntaRequest preguntaRequest, Transaction transaction) {


        Pregunta pregunta = new Pregunta();


        //  LOGGER.error(preguntaRequest.getCreationDate().toString());

        pregunta.setUserId(userId);
        pregunta.setProjectsId(preguntaRequest.getProjectsId());
        pregunta.setPregunta(preguntaRequest.getPregunta());
        pregunta.setStatus(1);
        pregunta.setTransaction(transaction);

        preguntaDao.newPregunta(pregunta);
        return preguntaRequest;
    }

    public PreguntaRequest editPregunta(PreguntaRequest preguntaRequest, Integer preguntaId, Integer userid, Transaction transaction) {
        Pregunta pregunta = new Pregunta();
        pregunta.setPreguntaId(preguntaId);
        pregunta.setPregunta(preguntaRequest.getPregunta());


        pregunta.setStatus(1);
        pregunta.setTransaction(transaction);
        preguntaDao.updatePregunta(pregunta);
        return preguntaRequest;
    }

    public Pregunta deleteCard(Integer preguntaId, Transaction transaction) {

        Pregunta pregunta = new Pregunta();


        pregunta.setPreguntaId(preguntaId);
        pregunta.setStatus(0);

        pregunta.setTransaction(transaction);
        preguntaDao.deletePregunta(pregunta);
        return pregunta;
    }



}
