package bo.ucb.edu.ingsoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bo.ucb.edu.ingsoft.model.Pregunta;

@Mapper
public interface PreguntaDao {
    public List<Pregunta>getPregunta(Integer proyectId);
    public Pregunta dataPreguntaId(Integer preguntaId);
    public void newPregunta(Pregunta pregunta);
    public void updatePregunta(Pregunta pregunta);
    public void deletePregunta(Pregunta pregunta);
}
