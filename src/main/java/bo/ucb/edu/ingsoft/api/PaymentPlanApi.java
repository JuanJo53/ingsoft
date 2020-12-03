package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.PaymentPlanBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.PaymentPlan;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/paymentPlan")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentPlanApi{
    private PaymentPlanBl paymentPlanBl;
    private TransactionBl transactionBl;

    @Autowired
    public PaymentPlanApi(PaymentPlanBl paymentPlanBl, TransactionBl transactionBl){
        this.paymentPlanBl = paymentPlanBl;
        this.transactionBl = transactionBl;
    }

    //post for paymentplan
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaymentPlanRequest createPaymentPlan(@RequestBody PaymentPlanRequest paymentPlanRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        PaymentPlanRequest paymentPlanResponse = paymentPlanBl.createPaymentPlan(1,paymentPlanRequest, transaction);
        return paymentPlanResponse;
    }

    //get for paymentplan
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentPlan> getPaymentPlans(HttpServletRequest request) {
        return paymentPlanBl.getPaymentsPlan();
    }

    @RequestMapping(value = "/{paymentplanid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentPlanRequest findbypaymentplanid(@PathVariable("paymentplanid") Integer id){
        return  paymentPlanBl.findByPaymentPlanId(id);
    }
}
