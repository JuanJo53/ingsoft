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
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/skills")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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


    @RequestMapping(value = "/userSkill/{iduser}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SkillRequest createSkill(@Valid @RequestBody SkillRequest skillRequest, HttpServletRequest request, @PathVariable("iduser") Integer userid) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        SkillRequest skillResponse = skillBl.createSkill(skillRequest, transaction, userid,1);
        return skillResponse;
    }
    @RequestMapping(value = "/projectSkill/{iduser}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SkillRequest createSkillprojecte(@Valid @RequestBody SkillRequest skillRequest, HttpServletRequest request,@PathVariable("iduser") Integer userid) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        SkillRequest skillResponse = skillBl.createSkill(skillRequest, transaction, userid,2);
        return skillResponse;
    }

    @RequestMapping(value = "/userSkill/{skillid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SkillRequest deleteSkill(@Valid @RequestBody SkillRequest skillRequest, HttpServletRequest request,@PathVariable("skillid") Integer skillid) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        SkillRequest skillResponse = skillBl.deleteskill(skillRequest, transaction, skillid);
        return skillResponse;
    }

    @RequestMapping(value = "/userSkill/update/{skillid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SkillRequest updateskill( @Valid @RequestBody SkillRequest skillRequest, HttpServletRequest request,@PathVariable("skillid") Integer skillid) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        SkillRequest skillResponse = skillBl.updateSkill(skillRequest, transaction, skillid);
        return skillResponse;
    }
}
