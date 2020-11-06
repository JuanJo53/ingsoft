package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CertificateBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public Certificate getUserCertificates(HttpServletRequest request) {
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
}
