package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.PaymentPlanBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import bo.ucb.edu.ingsoft.model.PaymentPlan;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/paymentPlan")
public class PaymentPlanApi{
    private PaymentPlanBl paymentPlanBl;
    private TransactionBl transactionBl;

    @Autowired
    public PaymentPlanApi(PaymentPlanBl paymentPlanBl, TransactionBl transactionBl){
        this.paymentPlanBl = paymentPlanBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaymentPlanRequest createPaymentPlan(@RequestBody PaymentPlanRequest paymentPlanRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        PaymentPlanRequest paymentPlanResponse = paymentPlanBl.createPaymentPlan(1,paymentPlanRequest, transaction);
        return paymentPlanResponse;
    }

}