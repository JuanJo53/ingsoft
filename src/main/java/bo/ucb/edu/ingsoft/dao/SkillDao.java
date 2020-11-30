package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Skill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SkillDao {
    public void newSkill(Skill skill);
    public Integer getLastIdSkill();
    public Skill getBySkillName(String skillName);
    public List<Skill> getSkills();
    public List<Skill> getUserSkills(Integer userid);
    public List<Skill> getProjectSkills(Integer projectid);
    public Integer getLastInsertId();
    public void deleteskill(Integer skillId);
    public void updateSkill(Skill skill);
}
