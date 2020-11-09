package bo.ucb.edu.ingsoft.model;

public class ProjectUser {
    private  Integer projectUserId;
    private Integer UserId;
    private Integer ProjectId;
    private Integer Rol;
    private Integer Status;
    private Transaction transaction;

    public ProjectUser() {
        transaction=new Transaction();
    }

    public Integer getProjectUserId() {
        return projectUserId;
    }

    public void setProjectUserId(Integer projectUserId) {
        this.projectUserId = projectUserId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getProjectId() {
        return ProjectId;
    }

    public void setProjectId(Integer projectId) {
        ProjectId = projectId;
    }

    public Integer getRol() {
        return Rol;
    }

    public void setRol(Integer rol) {
        Rol = rol;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
