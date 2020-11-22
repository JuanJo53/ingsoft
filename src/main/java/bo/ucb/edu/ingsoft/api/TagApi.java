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

    @RequestMapping(value="/userTag/{userid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
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

}
