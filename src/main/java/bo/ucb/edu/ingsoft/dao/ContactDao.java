package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Contact;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactDao {
    public Contact findByContactId(Integer contactId);
}
