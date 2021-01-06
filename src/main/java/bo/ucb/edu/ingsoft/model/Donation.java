package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class Donation {
    private Integer donationId;
    private Integer userId;
    private Integer cardId;
    private Integer projectsId;
    private Date donationDate;
    private Double amount;
    private Integer status;
    private Transaction transaction;

    public Donation(){
        transaction=new Transaction();
    }

    public Integer getDonationId() {
        return donationId;
    }

    public void setDonationId(Integer donationId) {
        this.donationId = donationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Integer projectsId) {
        this.projectsId = projectsId;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Donation{" +
                "donationId=" + donationId +
                ", userId=" + userId +
                ", cardId=" + cardId +
                ", projectsId=" + projectsId +
                ", donationDate=" + donationDate +
                ", amount=" + amount +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
