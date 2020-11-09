package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Certificate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertificateDao {
    public Certificate detailsByCertificateId(Integer certificateId);

    public List<Certificate> getCertificates(Integer userId);

    public void newCertificate(Certificate certificate);

}
