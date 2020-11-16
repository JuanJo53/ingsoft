package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.SkillDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.SkillRequest;
import bo.ucb.edu.ingsoft.model.Skill;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillBl {
    private SkillDao skillDao;
    private TransactionDao transactionDao;

    @Autowired
    public SkillBl(SkillDao skillDao, TransactionDao transactionDao){
        this.skillDao = skillDao;
        this.transactionDao = transactionDao;
    }

    public Skill getSkillByName(String skillName) {
        return  skillDao.getBySkillName(skillName);
    }

    public List<Skill> getAllSkills() {
        return  skillDao.getSkills();
    }

    public List<Skill> getUserSkills(Integer userid) {
        return  skillDao.getUserSkills(userid);
    }
    public List<Skill> getProjectSkills(Integer projectid) {
        return  skillDao.getProjectSkills(projectid);
    }

    public SkillRequest createSkill(SkillRequest skillRequest ,Transaction transaction){
        Skill skill = new Skill();

        skill.setSkillName(skillRequest.getSkillName());
        skill.setStatus(1);
        skill.setVerified(0);
        skill.setTransaction(transaction);

        skillDao.newSkill(skill);

        return skillRequest;
    }
}
