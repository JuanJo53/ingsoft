package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CertificateBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user/certificates")
public class CertificateApi {

    private CertificateBl certificateBl;
    private TransactionBl transactionBl;

    @Autowired
    public CertificateApi(CertificateBl certificateBl, TransactionBl transactionBl) {
        this.certificateBl = certificateBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Certificate> getUserCertificates(HttpServletRequest request) {
        return certificateBl.getCertificateBasicData(1);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CertificateRequest createCertificate(@RequestBody CertificateRequest certificateRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        CertificateRequest certificateResponse = certificateBl.createCertificate(1,certificateRequest, transaction);
        return certificateResponse;
    }

    @RequestMapping(value = "/edit/{certificateid}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CertificateRequest editCertificate(@PathVariable("certificateid") Integer certificateId, @RequestBody CertificateRequest certificateRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        CertificateRequest certificateResponse=certificateBl.editCertificate(certificateRequest,certificateId,transaction);
        //CertificateRequest certificateResponse = certificateBl.createCertificate(1,certificateRequest, transaction);
        return certificateResponse;
    }
}
