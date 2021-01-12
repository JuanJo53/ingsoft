package bo.ucb.edu.ingsoft.dto;

public class EvaluacionRequest {

    private String nroEvaluacion;
    private Integer preguntaId;
    private Integer proyectoId;
    private Integer respuestaCorrecta;
    private Integer respuestaUser;
    private Integer totalPreguntas;
    private Integer status;

    public EvaluacionRequest() {
    }


    public Integer getProyectoId() {
        return proyectoId;
    }


    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }


    public String getNroEvaluacion() {
        return nroEvaluacion;
    }

    public void setNroEvaluacion(String nroEvaluacion) {
        this.nroEvaluacion = nroEvaluacion;
    }

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Integer getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(Integer respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Integer getRespuestaUser() {
        return respuestaUser;
    }

    public void setRespuestaUser(Integer respuestaUser) {
        this.respuestaUser = respuestaUser;
    }

    public Integer getTotalPreguntas() {
        return totalPreguntas;
    }

    public void setTotalPreguntas(Integer totalPreguntas) {
        this.totalPreguntas = totalPreguntas;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



}
