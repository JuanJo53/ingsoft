package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.MediaBl;
import bo.ucb.edu.ingsoft.bl.TagBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.MediaRequest;
import bo.ucb.edu.ingsoft.dto.TagRequest;
import bo.ucb.edu.ingsoft.model.Media;
import bo.ucb.edu.ingsoft.model.Tag;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@RequestMapping(value = "/my-projects/{idproject}/media")
public class MediaApi {

    private MediaBl mediaBl;
    private TransactionBl transactionBl;

    @Autowired
    public MediaApi(MediaBl mediaBl, TransactionBl transactionBl) {
        this.mediaBl = mediaBl;
        this.transactionBl = transactionBl;
    }



    @RequestMapping(value = "/addMedia",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Media insertMedia(@RequestBody MediaRequest mediaRequest, @PathVariable("idproject") Integer id, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Media mediaResponse = mediaBl.insertmedia(mediaRequest,id,transaction);
        return mediaResponse;
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getVerifiedTags(HttpServletRequest request, @PathVariable("idproject") Integer idproject) {
        return mediaBl.getListMedia(idproject);
    }

}