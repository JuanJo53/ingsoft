package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Certificate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertificateDao {
    //This function returns details of an specific certificate
    public Certificate detailsByCertificateId(Integer userId, Integer certificateId);

    public List<Certificate> getCertificates(Integer userId);

    public void newCertificate(Certificate certificate);

    public void updateCertificate(Certificate certificate);

    public void deleteCertificate(Certificate certificate);

}
