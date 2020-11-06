package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class Project {
    private String projectTitle;
    private String description;
    private String abilities;
    private String benefits;
    private Integer views;
    private Integer status;
    private Date create_date;
    private Transaction transaction;

    public Project() {
        transaction=new Transaction();
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectTitle='" + projectTitle + '\'' +
                ", description='" + description + '\'' +
                ", abilities='" + abilities + '\'' +
                ", benefits='" + benefits + '\'' +
                ", views=" + views +
                ", status=" + status +
                ", create_date=" + create_date +
                ", txId=" + transaction.getTxId() +
                ", txHost=" + transaction.getTxHost() +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
