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

    public Certificate getCertificateDetails(Integer userid,Integer certificateId) {
        return  certificateDao.detailsByCertificateId(userid,certificateId);
    }
    //Function that gets all user certificates
    public List<Certificate> getCertificateBasicData(Integer userId) {
        return  certificateDao.getCertificates(userId);
    }

    public CertificateRequest createCertificate(Integer userId, CertificateRequest certificateRequest, Transaction transaction) {
        Certificate certificate = new Certificate();

        certificate.setUserId(userId);
        certificate.setCertificateName(certificateRequest.getCertificateName());
        certificate.setCompany(certificateRequest.getCompany());
        certificate.setExpeditionDate(certificateRequest.getExpeditionDate());
        certificate.setCredentialId(certificateRequest.getCredentialId());
        certificate.setCredentialURL(certificateRequest.getCredentialURL());
        certificate.setExpirationDate(certificateRequest.getExpirationDate());
        certificate.setStatus(1);

        certificate.setTransaction(transaction);

        certificateDao.newCertificate(certificate);

        return  certificateRequest;
    }
    public CertificateRequest editCertificate(CertificateRequest certificateRequest, Integer certificateId, Transaction transaction) {
        Certificate certificate = new Certificate();

        certificate.setCertificateId(certificateId);
        certificate.setCertificateName(certificateRequest.getCertificateName());
        certificate.setCompany(certificateRequest.getCompany());
        certificate.setExpeditionDate(certificateRequest.getExpeditionDate());
        certificate.setCredentialId(certificateRequest.getCredentialId());
        certificate.setCredentialURL(certificateRequest.getCredentialURL());
        certificate.setExpirationDate(certificateRequest.getExpirationDate());

        certificate.setTransaction(transaction);

        certificateDao.updateCertificate(certificate);

        return  certificateRequest;
    }
    public Certificate deleteCertificate(Integer certificateId, Transaction transaction) {
        Certificate certificate = new Certificate();

        LOGGER.info("Borrando certificado");
        certificate.setCertificateId(certificateId);
        certificate.setStatus(0);
        LOGGER.info("Certificado borrado exitosamente");


        certificate.setTransaction(transaction);

        certificateDao.deleteCertificate(certificate);

        return  certificate;
    }

}
