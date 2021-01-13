package bo.ucb.edu.ingsoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bo.ucb.edu.ingsoft.model.Respuesta;

@Mapper
public interface RespuestaDao {

    public List<Respuesta>getRespuesta(Integer userId);
    public Respuesta dataRespuestaId(Integer respuestaId);
    public void newRespuesta(Respuesta respuesta);
    public void deleteRespuesta(Respuesta respuesta);

}

