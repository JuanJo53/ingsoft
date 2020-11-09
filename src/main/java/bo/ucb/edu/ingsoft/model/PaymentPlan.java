package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class PaymentPlan {
    private Integer paymentPlanId;
    private String plan;
    private String description;
    private Integer cost;
    private Integer duration;
    private Date creationDate;
    private Transaction transaction;

    public PaymentPlan() {
        transaction=new Transaction();
    }

    public Integer getPaymentPlanId() {
        return paymentPlanId;
    }

    public void setPaymentPlanId(Integer paymentPlanId) {
        this.paymentPlanId = paymentPlanId;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "PaymentPlan{" +
                "paymentPlanId=" + paymentPlanId +
                ", plan='" + plan + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                ", creationDate=" + creationDate +
                ", txId=" + transaction.getTxId() +
                ", txHost=" + transaction.getTxHost() +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +
                '}';
    }
}
