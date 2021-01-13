package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class Project {
    private Integer projectsId;
    private String projectTitle;
    private String description;
    private String benefits;
    private Double budget;
    private Integer views;
    private Integer status;
    private Date createDate;
    private Transaction transaction;

    public Project() {
        transaction=new Transaction();
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectsId=" + projectsId +
                ", projectTitle='" + projectTitle + '\'' +
                ", description='" + description + '\'' +
                ", benefits='" + benefits + '\'' +
                ", budget=" + budget +
                ", views=" + views +
                ", status=" + status +
                ", createDate=" + createDate +
                ", transaction=" + transaction +
                '}';
    }

    public Integer getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Integer projectsId) {
        this.projectsId = projectsId;
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

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
