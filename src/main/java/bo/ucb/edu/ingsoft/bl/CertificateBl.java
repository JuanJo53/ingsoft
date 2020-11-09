package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CertificateDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Certificate detailsByCertificateId(Integer certificateId) {
        return  certificateDao.detailsByCertificateId(certificateId);
    }
    //Function that gets all user certificates
    public List<Certificate> getCertificateBasicData(Integer userId) {
        return  certificateDao.getCertificates(userId);
    }

    public CertificateRequest createCertificate(Integer userId, CertificateRequest certificateRequest, Transaction transaction) {
        Certificate certificate = new Certificate();

        LOGGER.error(certificateRequest.getExpirationDate().toString());
        LOGGER.error(certificateRequest.getExpeditionDate().toString());

        certificate.setUserId(userId);
        certificate.setName(certificateRequest.getName());
        certificate.setCompany(certificateRequest.getCompany());
        certificate.setExpeditionDate(certificateRequest.getExpeditionDate());
        certificate.setCredentialId(certificateRequest.getCredentialId());
        certificate.setCredentialURL(certificateRequest.getCredentialURL());
        certificate.setExpirationDate(certificateRequest.getExpirationDate());

        certificate.setTransaction(transaction);

        certificateDao.newCertificate(certificate);

        return  certificateRequest;
    }

    public CertificateRequest editCertificate(CertificateRequest certificateRequest, Integer certificateId, Transaction transaction) {
        Certificate certificate = new Certificate();

        certificate.setCertificateId(certificateId);
        certificate.setName(certificateRequest.getName());
        certificate.setCompany(certificateRequest.getCompany());
        certificate.setExpeditionDate(certificateRequest.getExpeditionDate());
        certificate.setCredentialId(certificateRequest.getCredentialId());
        certificate.setCredentialURL(certificateRequest.getCredentialURL());
        certificate.setExpirationDate(certificateRequest.getExpirationDate());

        LOGGER.error(certificate.getCertificateId().toString());
        LOGGER.error(certificate.getName());
        LOGGER.error(certificate.getCompany());
        LOGGER.error(certificate.getExpirationDate().toString());
        LOGGER.error(certificate.getCredentialId());
        LOGGER.error(certificate.getCredentialURL());
        LOGGER.error(certificate.getExpeditionDate().toString());

        certificate.setTransaction(transaction);

        certificateDao.updateCertificate(certificate);

        return  certificateRequest;
    }

}
