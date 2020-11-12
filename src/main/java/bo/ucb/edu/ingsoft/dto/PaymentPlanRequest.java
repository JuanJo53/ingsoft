package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class PaymentPlanRequest {
    private String plan;
    private String description;
    private Double cost;
    private Integer duration;
    private Integer status;

    //getters and setters
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

    //toString
    @Override
    public String toString() {
        return "PaymentPlanRequest{" +
                "plan='" + plan + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                ", status=" + status +
                '}';
    }
}
