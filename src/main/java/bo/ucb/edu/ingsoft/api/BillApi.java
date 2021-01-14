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
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.MediaType;

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
        // Billing Addresss
        if (billRequest.getBillingAddress().trim().length()<=3 || billRequest.getBillingAddress().length()==0 || billRequest.getBillingAddress().trim().equals(" ")) {
            throw new InvalidDataAccessApiUsageException("La direccion de envio debe tener mas 3 letras");
        }
        if (billRequest.getBillingAddress().trim().length()>=17 || billRequest.getBillingAddress().length()==0 || billRequest.getBillingAddress().trim().equals(" ")) {
            throw new InvalidDataAccessApiUsageException("la direccion de envio debe tener menos de 17 letras");
        }


        // Country

        if (billRequest.getCountry().trim().length()<=3 || billRequest.getCountry().length()==0 || billRequest.getCountry().trim().equals(" ")) {
            throw new InvalidDataAccessApiUsageException("El  pais debe tener mas 3 letras");
        }
        if (billRequest.getCountry().trim().length()>=17 || billRequest.getCountry().length()==0 || billRequest.getCountry().trim().equals(" ")) {
            throw new InvalidDataAccessApiUsageException("El pais debe tener menos de 17 letras");
        }

        // City
        if (billRequest.getCity().trim().length()<=3 || billRequest.getCity().length()==0 || billRequest.getCity().trim().equals(" ")) {
            throw new InvalidDataAccessApiUsageException("La ciudad debe tener mas 3 letras");
        }
        if (billRequest.getCity().trim().length()>=17 || billRequest.getCity().length()==0 || billRequest.getCity().trim().equals(" ")) {
            throw new InvalidDataAccessApiUsageException("la ciudad debe tener menos de 17 letras");
        }


        BillRequest billResponse = billBl.createBill(userid,projectid,planid,cardid,billRequest,transaction);
        return billResponse;
    }

    @RequestMapping(value = "/{userid}/bill",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BillRequest> getBills(@PathVariable("userid") Integer userid,HttpServletRequest request){
        return billBl.getBill(userid);
    }
}
