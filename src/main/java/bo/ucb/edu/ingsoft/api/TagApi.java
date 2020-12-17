package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.TagBl;

import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.TagRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Tag;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/tags")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TagApi {
    private TagBl tagBl;
    private TransactionBl transactionBl;

    @Autowired
    public TagApi(TagBl tagBl,TransactionBl transactionBl) {
        this.tagBl = tagBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value="/user/{userid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tag createnewtag(@RequestBody TagRequest tagRequest, @PathVariable("userid") Integer id, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Tag tagResponse = tagBl.createNewTag(tagRequest,id,transaction);
        return tagResponse;
    }
    @RequestMapping(value = "/{tagname}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tag gettag( @PathVariable("tagname") String tag) {
        Tag tagNameResponse = tagBl.getTagByName(tag);
        return tagNameResponse;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tag> getVerifiedTags(HttpServletRequest request) {
        return tagBl.getAllVerifiedTags();
    }
    @RequestMapping(value="/user/{userid}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tag> getUserTag(HttpServletRequest request,@PathVariable("userid") Integer id) {
        return tagBl.getusertag(id);
    }
    @RequestMapping(value = "/{tagid}/user/{userid}" ,method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletetaguser(@PathVariable("tagid") Integer tagid,@PathVariable("userid") Integer userid, HttpServletRequest request) {
        tagBl.deletetag(tagid,userid);
    }
    @RequestMapping(value = "/{tagid}/project/{projectid}" ,method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletetagproject(@PathVariable("tagid") Integer tagid,@PathVariable("projectid") Integer projectid, HttpServletRequest request) {
        tagBl.deletetagproject(tagid,projectid);
    }
    @RequestMapping(value="/user/{userid}/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tag addtagtouser(@RequestBody Tag tag, @PathVariable("userid") Integer id, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Tag tagResponse = tagBl.addTagToUser(tag,id);
        return tagResponse;
    }
    @RequestMapping(value="projects/{projectid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tag addtagtoproject(@RequestBody TagRequest tag, @PathVariable("projectid") Integer id, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Tag tagResponse = tagBl.addTagToProject(tag,id,transaction);
        return tagResponse;
    }
    @RequestMapping(value="projects/{projectid}/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tag addtoproject(@RequestBody Tag tag, @PathVariable("projectid") Integer id, HttpServletRequest request) {
        Tag tagResponse = tagBl.addToProject(tag,id);
        return tagResponse;
    }
    @RequestMapping(value="projects/{projectid}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tag> getProjectTags(@PathVariable("projectid") Integer id,HttpServletRequest request) {
        return tagBl.getAllProjectTags(id);
    }
}
