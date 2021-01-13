package bo.ucb.edu.ingsoft.dto;

public class RespuestaRequest {

    private String respuesta;
    private Integer preguntaId;
    private Boolean respuestaCorrecta;

    public RespuestaRequest() {
    }


    public String getRespuesta() {
        return respuesta;
    }


    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }


    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Boolean getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(Boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }




}
