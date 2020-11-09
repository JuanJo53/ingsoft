package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class PaymentPlanRequest {
    private String plan;
    private String description;
    private Double cost;
    private Integer duration;
    private Date creationDate;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "PaymentPlanRequest{" +
                "plan='" + plan + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                ", creationDate=" + creationDate +
                '}';
    }
}
