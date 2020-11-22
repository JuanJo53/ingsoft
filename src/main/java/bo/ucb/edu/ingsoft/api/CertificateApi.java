package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CertificateBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user")

public class CertificateApi {

    private CertificateBl certificateBl;
    private TransactionBl transactionBl;

    @Autowired
    public CertificateApi(CertificateBl certificateBl, TransactionBl transactionBl) {
        this.certificateBl = certificateBl;
        this.transactionBl = transactionBl;
    }
    //GET function that gets all user certificates
    @RequestMapping(value = "/{userid}/certificates" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CertificateRequest> getUserCertificates(@PathVariable("userid") Integer userid,HttpServletRequest request) {
        return certificateBl.getCertificateBasicData(userid);
    }
    //POST function that creates a new certificate for a user
    @RequestMapping(value = "/{userid}/certificates" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CertificateRequest createCertificate(@PathVariable("userid") Integer userid,@RequestBody CertificateRequest certificateRequest, HttpServletRequest request) {
        // Creating transaction for this operation
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        // Executing the update function in CertificateBl
        CertificateRequest certificateResponse = certificateBl.createCertificate(userid,certificateRequest, transaction);
        return certificateResponse;
    }
    //GET function that gets user certificate details
    @RequestMapping(value = "/{userid}/certificates/{certificateid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CertificateRequest getCertificateDetails(@PathVariable("userid") Integer userid,@PathVariable("certificateid") Integer certificateid,HttpServletRequest request) {
        return certificateBl.getCertificateDetails(userid,certificateid);
    }
    //PUT function that updates a user certificate data
    @RequestMapping(value = "/{userid}/certificates/{certificateid}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CertificateRequest editCertificate(@PathVariable("certificateid") Integer certificateId, @RequestBody CertificateRequest certificateRequest, HttpServletRequest request) {
        // Creating transaction for this operation
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        // Executing the update function in CertificateBl
        CertificateRequest certificateResponse=certificateBl.editCertificate(certificateRequest,certificateId,transaction);
        return certificateResponse;
    }
    @RequestMapping(value = "/{userid}/certificates/{certificateid}" ,method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Certificate deleteCertificate(@PathVariable("certificateid") Integer certificateId, HttpServletRequest request) {
        // Creating transaction for this operation
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        // Executing the delete function in CertificateBl
        Certificate certificateResponse=certificateBl.deleteCertificate(certificateId,transaction);
        return certificateResponse;
    }
}
