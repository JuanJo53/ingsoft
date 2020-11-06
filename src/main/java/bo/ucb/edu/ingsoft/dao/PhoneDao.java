package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Phone;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhoneDao {
    public void create(Phone phone);
}
