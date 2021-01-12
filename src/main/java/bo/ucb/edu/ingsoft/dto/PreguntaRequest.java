package bo.ucb.edu.ingsoft.dto;

public class PreguntaRequest {
    private String pregunta;
    private Integer projectsId;

    public PreguntaRequest() {
    }

    public Integer getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Integer projectsId) {
        this.projectsId = projectsId;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }




}
