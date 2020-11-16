package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Skill;
import bo.ucb.edu.ingsoft.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SkillDao {
    public void newSkill(Skill skill);
    public Integer getLastIdSkill();
    public Skill getBySkillName(String skillName);
    public List<Tag> getSkills();
}
