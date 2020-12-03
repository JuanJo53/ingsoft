package bo.ucb.edu.ingsoft.model;

import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;

import java.util.Date;

public class PaymentPlan{
    private Integer paymentPlanId;
    private String plan;
    private String description;
    private Double cost;
    private Integer duration;
    private Integer status;
    private Transaction transaction;

    //transaction
    public PaymentPlan() {
        transaction=new Transaction();
    }

    //getters and setters
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    //toString with transaction
    @Override
    public String toString() {
        return "PaymentPlan{" +
                "paymentPlanId=" + paymentPlanId +
                ", plan='" + plan + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
