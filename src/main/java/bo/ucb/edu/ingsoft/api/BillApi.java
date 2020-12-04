package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.BillBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.BillRequest;
import bo.ucb.edu.ingsoft.model.Bill;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillApi {
    private BillBl billBl;
    private TransactionBl transactionBl;

    @Autowired
    public BillApi(BillBl billBl,TransactionBl transactionBl){
        this.billBl = billBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{userid}/projects/{projectid}/paymentplan/{planid}/{cardid}",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BillRequest createBill(@PathVariable("userid") Integer userid,@PathVariable("projectid") Integer projectid,@PathVariable("planid") Integer planid,@PathVariable("cardid") Integer cardid,@RequestBody BillRequest billRequest,HttpServletRequest request){
        //Creamos transaccion para la operacion
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        BillRequest billResponse = billBl.createBill(userid,projectid,planid,cardid,billRequest,transaction);
        return billResponse;
    }

    @RequestMapping(value = "/{userid}/bill",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BillRequest> getBills(@PathVariable("userid") Integer userid,HttpServletRequest request){
        return billBl.getBill(userid);
    }
}
