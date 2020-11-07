package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class Bill {
    private Integer billId;
    private Integer userId;
    private Integer paymentPlanId;
    private Integer cardId;
    private Date date;
    private String billingAddress;
    private String country;
    private Date city;
    private Transaction transaction;

    public Bill() {
        transaction=new Transaction();
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Date getCity() {
        return city;
    }

    public void setCity(Date city) {
        this.city = city;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", userId=" + userId +
                ", paymentPlanId=" + paymentPlanId +
                ", cardId=" + cardId +
                ", date=" + date +
                ", billingAddress='" + billingAddress + '\'' +
                ", country='" + country + '\'' +
                ", city=" + city +
                ", transaction=" + transaction +
                ", txId=" + transaction.getTxId() +
                ", txHost=" + transaction.getTxHost() +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +

                '}';
    }
}
