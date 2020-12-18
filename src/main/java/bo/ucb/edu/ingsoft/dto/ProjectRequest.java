package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProjectRequest {
    @NotBlank(message = "Name is mandatory")
    private String projectTitle;
    @NotBlank(message = "Name is mandatory")
    private String description;
    @NotBlank(message = "beneficios no pueden estar en blanco ")
    private String benefits;
    private Integer status;

    @Override
    public String toString() {
        return "ProyectRequest{" +
                "projectTitle='" + projectTitle + '\'' +
                ", description='" + description + '\'' +
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
