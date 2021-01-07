package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.DonationBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.DonationRequest;
import bo.ucb.edu.ingsoft.model.Donation;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DonationApi {
    private DonationBl donationBl;
    private TransactionBl transactionBl;

    @Autowired
    public DonationApi(DonationBl donationBl,TransactionBl transactionBl){
        this.donationBl = donationBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{userid}/projects/{projectid}/{cardid}",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)

    public DonationRequest createDonation(@PathVariable("userid") Integer userid, @PathVariable("projectid") Integer projectid, @PathVariable("cardid") Integer cardid, @RequestBody DonationRequest donationRequest, HttpServletRequest request){

        //Creamos transaccion para la operacion
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        DonationRequest donationResponse = donationBl.createDonation(userid,projectid,cardid,donationRequest,transaction);

        return donationResponse;
    }

    @RequestMapping(value = "/{userid}/donation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DonationRequest> getDonations(@PathVariable("userid") Integer userid,HttpServletRequest request){
        return donationBl.getDonation(userid);
    }

}
