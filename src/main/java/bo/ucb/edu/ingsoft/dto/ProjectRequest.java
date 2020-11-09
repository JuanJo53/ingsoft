package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import java.util.Date;

public class ProjectRequest {
    private String projectTitle;
    private String description;
    private String abilities;
    private String benefits;
    private Integer status;

    @Override
    public String toString() {
        return "ProyectRequest{" +
                "projectTitle='" + projectTitle + '\'' +
                ", description='" + description + '\'' +
                ", abilities='" + abilities + '\'' +
                ", benefits='" + benefits + '\'' +
                ", status=" + status +
                '}';
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
