package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CardBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Card;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user/card")
public class CardApi {

    private CardBl cardBl;
    private TransactionBl transactionBl;

    @Autowired
    public CardApi(CardBl cardBl, TransactionBl transactionBl) {
        this.cardBl = cardBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Card> getUserCard(HttpServletRequest request) {
        return cardBl.getCardBasicData(1);
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CardRequest createCard(@RequestBody CardRequest cardRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        CardRequest cardResponse = cardBl.createCard(1, cardRequest, transaction);
        return cardResponse;
    }

    @RequestMapping(value = "/edit/{cardid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public CardRequest editCard(@PathVariable("cardid") Integer cardId, @RequestBody CardRequest cardRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        CardRequest cardResponse = cardBl.editCard(cardRequest, cardId, transaction);
        //CertificateRequest certificateResponse = certificateBl.createCertificate(1,certificateRequest, transaction);
        return cardResponse;
    }
}











