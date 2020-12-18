package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.AreaBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.AreaRequest;
import bo.ucb.edu.ingsoft.dto.SkillRequest;
import bo.ucb.edu.ingsoft.model.Area;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/area")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AreaApi {
    private AreaBl areaBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaApi.class);

    @Autowired
    public AreaApi(AreaBl areaBl, TransactionBl transactionBl) {
        this.areaBl = areaBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/Projectarea/{idproject}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Area createarea(@Valid @RequestBody AreaRequest    areaRequest, HttpServletRequest request, @PathVariable("idproject") Integer projectid) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        LOGGER.info(areaRequest.getNameArea()+"  hola sadasdasd");
        Area area=areaBl.createArea(areaRequest,transaction,projectid);
         return area ;
    }
    @RequestMapping(value = "/Projectarealist/{idproject}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Area> createarea(@PathVariable("idproject") Integer projectid) {

        return areaBl.getAreaProjectlist(projectid);
    }

    @RequestMapping(value = "/Projectarea/{idarea}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Area updatearea( @Valid @RequestBody AreaRequest    areaRequest, HttpServletRequest request, @PathVariable("idarea") Integer idarea) {

        LOGGER.info(areaRequest.getNameArea()+"  hola sadasdasd");
        Area area=areaBl.editArea(areaRequest,idarea);
        return area ;
    }

}
