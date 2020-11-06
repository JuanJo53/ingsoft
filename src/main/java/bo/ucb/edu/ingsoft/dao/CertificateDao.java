package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Contact;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateDao {
    public Certificate detailsByCertificateId(Integer certificateId);
    public Certificate getCertificateBasicData(Integer user);
}
