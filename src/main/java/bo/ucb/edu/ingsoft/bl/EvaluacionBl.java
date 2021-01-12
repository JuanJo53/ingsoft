package bo.ucb.edu.ingsoft.bl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.ucb.edu.ingsoft.dao.EvaluacionDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.EvaluacionRequest;
import bo.ucb.edu.ingsoft.model.Evaluacion;
import bo.ucb.edu.ingsoft.model.Transaction;

@Service
public class EvaluacionBl {
    private EvaluacionDao evaluacionDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(EvaluacionBl.class);

    @Autowired
    public EvaluacionBl(EvaluacionDao evaluacionDao, TransactionDao transactionDao) {
        this.evaluacionDao = evaluacionDao;
        this.transactionDao = transactionDao;
    }

    public Evaluacion getEvaluacionDetails(Integer userid, Integer evaluacionid) {
        return evaluacionDao.dataEvaluacionId(evaluacionid);
    }

    //Function that gets all user certificates
    public List<Evaluacion> getEvaluacionBasicData(Integer proyectoId) {
        return evaluacionDao.getEvaluacion(proyectoId);
    }

    public EvaluacionRequest createEvaluacion(Integer userId, EvaluacionRequest evaluacionRequest, Transaction transaction) {

        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNroEvaluacion(evaluacionRequest.getNroEvaluacion());
        evaluacion.setPreguntaId(evaluacionRequest.getPreguntaId());
        evaluacion.setProyectoId(evaluacionRequest.getProyectoId());
        evaluacion.setRespuestaCorrecta(evaluacionRequest.getRespuestaCorrecta());
        evaluacion.setRespuestaUser(evaluacionRequest.getRespuestaUser());
        evaluacion.setTotalPreguntas(evaluacionRequest.getTotalPreguntas());
        evaluacion.setUserId(userId);
        evaluacion.setStatus(1);
        evaluacion.setTransaction(transaction);
        evaluacionDao.newEvaluacion(evaluacion);
        return evaluacionRequest;
    }

    public EvaluacionRequest editEvaluacion(EvaluacionRequest evaluacionRequest, Integer evaluacionId, Integer userid, Transaction transaction) {
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNroEvaluacion(evaluacionRequest.getNroEvaluacion());
        evaluacion.setPreguntaId(evaluacionRequest.getPreguntaId());
        evaluacion.setRespuestaCorrecta(evaluacionRequest.getRespuestaCorrecta());
        evaluacion.setRespuestaUser(evaluacionRequest.getRespuestaUser());
        evaluacion.setTotalPreguntas(evaluacionRequest.getTotalPreguntas());
        evaluacion.setUserId(userid);
        evaluacion.setStatus(1);
        evaluacion.setTransaction(transaction);
        evaluacionDao.updateEvaluacion(evaluacion);
        return evaluacionRequest;
    }

    public Evaluacion deleteEvaluacion(Integer evaluacionId, Transaction transaction) {
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setEvaluacionId(evaluacionId);
        evaluacion.setStatus(0);
        evaluacion.setTransaction(transaction);
        evaluacionDao.deleteEvaluacion(evaluacion);
        return evaluacion;
    }




}
