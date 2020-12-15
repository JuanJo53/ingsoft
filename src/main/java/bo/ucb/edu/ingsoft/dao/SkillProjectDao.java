package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.SkillProject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkillProjectDao {
    public void newSkillProject(SkillProject skillProject);

}
