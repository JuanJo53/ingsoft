package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.SkillUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface skillUserDao {
    public void newSkillUser(SkillUser skilluser);

}
