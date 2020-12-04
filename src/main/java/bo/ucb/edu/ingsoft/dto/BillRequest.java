package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import java.util.Date;

public class BillRequest {
    private Integer billId;
    private Integer userId;
    private Integer paymentPlanId;
    private Integer cardId;
    private Integer projectsId;
    private Date buyDate;
    private String billingAddress;
    private String country;
    private String city;
    private String projectTitle;
    private String paymentPlanName;
    private Double paymentPlanCost;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaymentPlanId() {
        return paymentPlanId;
    }

    public void setPaymentPlanId(Integer paymentPlanId) {
        this.paymentPlanId = paymentPlanId;
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

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getPaymentPlanName() {
        return paymentPlanName;
    }

    public void setPaymentPlanName(String paymentPlanName) {
        this.paymentPlanName = paymentPlanName;
    }

    public Double getPaymentPlanCost() {
        return paymentPlanCost;
    }

    public void setPaymentPlanCost(Double paymentPlanCost) {
        this.paymentPlanCost = paymentPlanCost;
    }

    @Override
    public String toString() {
        return "BillRequest{" +
                "billId=" + billId +
                ", userId=" + userId +
                ", paymentPlanId=" + paymentPlanId +
                ", cardId=" + cardId +
                ", projectsId=" + projectsId +
                ", buyDate=" + buyDate +
                ", billingAddress='" + billingAddress + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
