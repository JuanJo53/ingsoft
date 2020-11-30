package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.SkillDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.skillUserDao;
import bo.ucb.edu.ingsoft.dto.SkillRequest;
import bo.ucb.edu.ingsoft.model.Skill;
import bo.ucb.edu.ingsoft.model.SkillUser;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillBl {
    private SkillDao skillDao;
    private TransactionDao transactionDao;
    private skillUserDao skilluserDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(SkillBl.class);
    @Autowired
    public SkillBl(SkillDao skillDao, TransactionDao transactionDao, skillUserDao skilluserDao){
        this.skillDao = skillDao;
        this.transactionDao = transactionDao;
        this.skilluserDao = skilluserDao;
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

    public SkillRequest createSkill(SkillRequest skillRequest ,Transaction transaction,Integer iduser){
        Skill skill = new Skill();

        skill.setSkillName(skillRequest.getSkillName());
        skill.setStatus(1);
        skill.setVerified(0);
        skill.setTransaction(transaction);

        skillDao.newSkill(skill);
        Integer lastkill =skillDao.getLastInsertId();
        LOGGER.info("idskill: "+lastkill);
        SkillUser skilluser = new SkillUser();

        skilluser.setSkillId(lastkill);
        skilluser.setUserId(iduser);


        skilluserDao.newSkillUser(skilluser);

        return skillRequest;
    }

    public SkillRequest deleteskill(SkillRequest skillRequest,Transaction transaction, Integer skillid){
        skillDao.deleteskill(skillid);
        return skillRequest;
    }
    public SkillRequest updateSkill(SkillRequest skillRequest,Transaction transaction, Integer skillid){
        Skill skill= new Skill();
        skill.setSkillId(skillid);
        skill.setSkillName(skillRequest.getSkillName());
        skillDao.updateSkill(skill);
        return skillRequest;
    }
}
