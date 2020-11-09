package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Certificate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateDao {
    public Certificate detailsByCertificateId(Integer certificateId);

    public Certificate getCertificates(Integer userId);

    public void newCertificate(Certificate certificate);

}
