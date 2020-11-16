package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.SkillBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.SkillRequest;
import bo.ucb.edu.ingsoft.model.Skill;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/skills")
public class SkillApi {
    private SkillBl skillBl;
    private TransactionBl transactionBl;

    @Autowired
    public SkillApi(SkillBl skillBl, TransactionBl transactionBl) {
        this.skillBl = skillBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{skillname}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Skill getSkillByName(@PathVariable("skillname") String skillname, HttpServletRequest request) {
        return skillBl.getSkillByName(skillname);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Skill> getAllSkills(HttpServletRequest request) {
        return skillBl.getAllSkills();
    }
    @RequestMapping(value = "/userskills/{userid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Skill> getUserSkills(@PathVariable("userid") Integer userid, HttpServletRequest request) {
        return skillBl.getUserSkills(userid);
    }
    @RequestMapping(value = "/projectkills/{projectid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Skill> getProjectSkills(@PathVariable("projectid") Integer projectid, HttpServletRequest request) {
        return skillBl.getProjectSkills(projectid);
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SkillRequest createSkill(@RequestBody SkillRequest skillRequest, HttpServletRequest request) {
        // Creating transaction for this operation
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        // Executing the update function in CertificateBl
        SkillRequest skillResponse = skillBl.createSkill(skillRequest, transaction);
        return skillResponse;
    }
}
