package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import bo.ucb.edu.ingsoft.model.PaymentPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentPlanDao {
    public PaymentPlan detailsByPaymentPlanId(Integer paymentPlanId);
    public void newPaymentPlan(PaymentPlan paymentPlan);
    public List<PaymentPlan> getPaymentPlans();

}
