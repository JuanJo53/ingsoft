package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertificateDao {
    //This function returns details of an specific certificate
    public CertificateRequest detailsByCertificateId(Integer userId, Integer certificateId);
    //This function returns all user certificates of an specific user
    public List<CertificateRequest> getCertificates(Integer userId);
    //This function creates a new certificate
    public void newCertificate(Certificate certificate);
    //This function updates an specific certificate
    public void updateCertificate(Certificate certificate);
    //This function deletes (updates status) an specific certificate
    public void deleteCertificate(Certificate certificate);

}
