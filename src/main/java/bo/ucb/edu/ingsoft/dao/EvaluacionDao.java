package bo.ucb.edu.ingsoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bo.ucb.edu.ingsoft.model.Evaluacion;

@Mapper
public interface EvaluacionDao {
    public List<Evaluacion>getEvaluacion(Integer proyectoId);
    public Evaluacion dataEvaluacionId(Integer evaluacionId);
    public void newEvaluacion(Evaluacion evaluacion);
    public void updateEvaluacion(Evaluacion evaluacion);
    public void deleteEvaluacion(Evaluacion evaluacion);

}
