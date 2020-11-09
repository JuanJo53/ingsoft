package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.PaymentPlan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentPlanDao {
    public PaymentPlan detailsByPaymentPlanId(Integer paymentPlanId);
    public void newPaymentPlan(PaymentPlan paymentPlan);
}
