package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CertificateDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.BillRequest;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CertificateBl {
    private CertificateDao certificateDao;
    private TransactionDao transactionDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateBl.class);
    @Autowired
    public CertificateBl( CertificateDao certificateDao, TransactionDao transactionDao){
        this.certificateDao = certificateDao;
        this.transactionDao = transactionDao;
    }
    //This function gets a user certificate details, so user can edit this details
    public CertificateRequest getCertificateDetails(Integer userid,Integer certificateId) {
        return  certificateDao.detailsByCertificateId(userid,certificateId);
    }
    //This function gets all user certificates basic data for showing it in a list by executing a query function in certificateDao
    public List<CertificateRequest> getCertificateBasicData(Integer userId) {
        return  certificateDao.getCertificates(userId);
    }
    //This function creates a user certificate by executing an insert function in certificateDao
    public CertificateRequest createCertificate(Integer userId, CertificateRequest certificateRequest, Transaction transaction) {
        validationCertificate(certificateRequest);
        Certificate certificate = new Certificate();
        //Setting all the data sent from the body in CertificateRequest to the certificate class.
        certificate.setUserId(userId);
        certificate.setCertificateName(certificateRequest.getCertificateName());
        certificate.setCompany(certificateRequest.getCompany());
        certificate.setExpeditionDate(certificateRequest.getExpeditionDate());
        certificate.setCredentialId(certificateRequest.getCredentialId());
        certificate.setCredentialURL(certificateRequest.getCredentialURL());
        certificate.setExpirationDate(certificateRequest.getExpirationDate());
        certificate.setStatus(1);   //status = 1: ACVITE CERTIFICATE
        //setting the last transaction data
        certificate.setTransaction(transaction);
        //Executing insert function to certificateDao
        certificateDao.newCertificate(certificate);

        return  certificateRequest;
    }
    //This function updates a user certificate data by executing an update function in certificateDao
    public CertificateRequest editCertificate(CertificateRequest certificateRequest, Integer certificateId, Transaction transaction) {
        validationCertificate(certificateRequest);
        Certificate certificate = new Certificate();
        //Setting all the data sent from the body in CertificateRequest to the certificate class.
        certificate.setCertificateId(certificateId);
        certificate.setCertificateName(certificateRequest.getCertificateName());
        certificate.setCompany(certificateRequest.getCompany());
        certificate.setExpeditionDate(certificateRequest.getExpeditionDate());
        certificate.setCredentialId(certificateRequest.getCredentialId());
        certificate.setCredentialURL(certificateRequest.getCredentialURL());
        certificate.setExpirationDate(certificateRequest.getExpirationDate());
        //setting the last transaction data
        certificate.setTransaction(transaction);
        //Executing update function from certificateDao
        certificateDao.updateCertificate(certificate);

        return  certificateRequest;
    }
    //This function deletes a user certificate data by executing an update function in certificateDao and changing it´s status
    public Certificate deleteCertificate(Integer certificateId, Transaction transaction) {
        Certificate certificate = new Certificate();

        LOGGER.info("Deleting certificate");
        certificate.setCertificateId(certificateId);
        certificate.setStatus(0);   //Setting status=0: CERTIFICATE DELETED
        LOGGER.info("Certificate deleted succesfuly");
        //setting the last transaction data
        certificate.setTransaction(transaction);
        //Executing update function from certificateDao
        certificateDao.deleteCertificate(certificate);

        return  certificate;
    }


    private void validationCertificate(CertificateRequest certificateRequest) {
        String regex_certificate = "[A-Za-zÁÉÍÓÚáéíóúñÑ0-9 ]{4,60}";
        Pattern pattern = Pattern.compile(regex_certificate);
        Matcher matcher = pattern.matcher(certificateRequest.getCertificateName());
        if (!matcher.matches()) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Nombre del certificado incorrecto.");
        }

        String regex_company = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]{3,60}";
        Pattern pattern_company = Pattern.compile(regex_company);
        Matcher matcher_company = pattern_company.matcher(certificateRequest.getCompany());
        if (!matcher_company.matches()) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Nombre de empresa incorrecto.");
        }

        if (certificateRequest.getExpeditionDate().before(new Date())) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Fecha de expedidición incorrecta.");
        }

        if (certificateRequest.getExpirationDate().before(new Date())) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Fecha de expiracion incorrecta.");
        }

        Pattern pattern_id = Pattern.compile("[A-Za-zÁÉÍÓÚáéíóúñÑ0-9]{0,60}");
        Matcher matcher_id = pattern_id.matcher(certificateRequest.getCredentialId());
        if (!matcher_id.matches()) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Identificador del credencial incorrecto.");
        }

        Pattern pattern_url = Pattern.compile("^(http|https):[-a-zA-Z0-9+&@#/%?=~_|!:,.;]{0,}");
        Matcher matcher_url = pattern_url.matcher(certificateRequest.getCredentialURL());
        if (!matcher_url.matches()) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Url del credencial incorrecto.");
        }

    }

}

