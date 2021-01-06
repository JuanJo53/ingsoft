package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class DonationRequest {
    private Integer donationId;
    private Integer userId;
    private Integer cardId;
    private Integer projectsId;
    private Date donationDate;
    private Double amount;
    private String projectTitle;
    private String projectDescription;
    private Integer cardNumber;

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

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "DonationRequest{" +
                "donationId=" + donationId +
                ", userId=" + userId +
                ", cardId=" + cardId +
                ", projectsId=" + projectsId +
                ", donationDate=" + donationDate +
                ", amount=" + amount +
                '}';
    }
}
