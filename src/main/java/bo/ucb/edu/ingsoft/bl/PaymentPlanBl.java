package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PaymentPlanDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.PaymentPlan;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  PaymentPlanBl  {
    private PaymentPlanDao paymentPlanDao;
    private TransactionDao transactionDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPlanBl.class);

    @Autowired
    public PaymentPlanBl(PaymentPlanDao paymentPlanDao, TransactionDao transactionDao) {
        this.paymentPlanDao = paymentPlanDao;
        this.transactionDao = transactionDao;
    }

    //payment plan request
    public PaymentPlanRequest createPaymentPlan( Integer paymentPlanId,PaymentPlanRequest paymentPlanRequest,Transaction transaction){
        PaymentPlan paymentPlan = new PaymentPlan();
       //payment plan data
        paymentPlan.setPaymentPlanId(paymentPlanId);
        paymentPlan.setPlan(paymentPlanRequest.getPlan());
        paymentPlan.setDescription(paymentPlanRequest.getDescription());
        paymentPlan.setCost(paymentPlanRequest.getCost());
        paymentPlan.setDuration(paymentPlanRequest.getDuration());
        paymentPlan.setStatus(1);

        paymentPlan.setTransaction(transaction);
        paymentPlanDao.newPaymentPlan(paymentPlan);

        return paymentPlanRequest;
    }

    public List<PaymentPlan> getPaymentsPlan(){ return  paymentPlanDao.getPaymentPlans();
    }

    public PaymentPlanRequest findByPaymentPlanId (Integer id1){
        PaymentPlanRequest paymentPlan = paymentPlanDao.findByPaymentPlanId(id1);
        return paymentPlan;
    }

}
