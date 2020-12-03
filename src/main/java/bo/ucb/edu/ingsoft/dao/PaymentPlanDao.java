package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import bo.ucb.edu.ingsoft.model.PaymentPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentPlanDao {
    //paymentPlan details
    public PaymentPlanRequest findByPaymentPlanId(Integer paymentPlanId);
    //paymentPlan new
    public void newPaymentPlan(PaymentPlan paymentPlan);
    //paymentPlan get
    public List<PaymentPlan> getPaymentPlans();

}
