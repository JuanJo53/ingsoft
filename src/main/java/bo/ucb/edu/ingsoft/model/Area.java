package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class Area {

    private Integer AreaId;
    private String nameArea;
    private Date creationDate;
    private Integer status;
    private Transaction transaction;

    @Override
    public String toString() {
        return "Area{" +
                "AreaId=" + AreaId +
                ", nameArea='" + nameArea + '\'' +
                ", creationDate=" + creationDate +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }

    public Area() {transaction=new Transaction();}

    public Integer getAreaId() {
        return AreaId;
    }

    public void setAreaId(Integer areaId) {
        AreaId = areaId;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
