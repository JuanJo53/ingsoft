package bo.ucb.edu.ingsoft.api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.ucb.edu.ingsoft.bl.CardBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Card;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardApi {

    private CardBl cardBl;
    private TransactionBl transactionBl;

    @Autowired
    public CardApi(CardBl cardBl, TransactionBl transactionBl) {
        this.cardBl = cardBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{userid}/card",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Card> getUserCard(@PathVariable("userid") Integer userid, HttpServletRequest request) {
        return cardBl.getCardBasicData(userid);
    }

    @RequestMapping(value = "/{userid}/card/{cardid}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Card getUserCardDetails(@PathVariable("userid") Integer userid,@PathVariable("cardid") Integer cardid, HttpServletRequest request) {
        return cardBl.getCardDetails(userid,cardid);
    }

    @RequestMapping(value = "/{userid}/card",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CardRequest createCard(@PathVariable("userid") Integer userid,@RequestBody CardRequest cardRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        Boolean isCardN=  cardBl.isCardName(userid,cardRequest.getCardName());
        Boolean isCardNum=  cardBl.isCardNumber(userid,cardRequest.getCardNumber());

        CardRequest cardResponse = null;


        // CardName
        if (cardRequest.getCardName().trim().length()<=3 || cardRequest.getCardName().length()==0 || cardRequest.getCardName().toString().trim().equals(" ")) {
            throw new InvalidDataAccessApiUsageException("El nombre debe tener mas 3 letras");
        }


        // CardNumber
        if (cardRequest.getCardNumber().toString().trim().length()<11 || cardRequest.getCardNumber().toString().length()==0) {
            System.out.println("El numero debe tener mas 11 digitos");
            throw new InvalidDataAccessApiUsageException("El numero debe tener mas 11 digitos");

        }

        if (cardRequest.getCardNumber().toString().trim().length()>16 || cardRequest.getCardNumber().toString().length()==0) {
            throw new InvalidDataAccessApiUsageException("El numero debe tener menos de  16 digitos");
        }



        // ExpirationYear
        if (cardRequest.getExpirationYear().toString().trim().length()==0) {
            throw new InvalidDataAccessApiUsageException("El año es requerido");
        }

        // ExpirationMonth
        if (cardRequest.getExpirationMonth().toString().trim().length()==0) {
            throw new InvalidDataAccessApiUsageException("El mes es requerido");
        }



        //cvc
        if (cardRequest.getCvc().toString().trim().length()<3 || cardRequest.getCvc().toString().length()==0) {
            System.out.println("El CVC debe tener minimo 3 digitos");
            throw new InvalidDataAccessApiUsageException("El CVC debe tener minimo 3 digitos");
        }

        if (cardRequest.getCvc().toString().trim().length()>4 || cardRequest.getCvc().toString().length()==0) {
            System.out.println("El CVC debe tener minimo 3 digitos");
            throw new InvalidDataAccessApiUsageException("El CVC debe tener como maximo 4 digitos");
        }


        // ExpirationMonth
        if (cardRequest.getCreationDate().toString().trim().length()==0) {
            throw new InvalidDataAccessApiUsageException("La fecha es requerido");
        }


        if (isCardNum) {

            throw new InvalidDataAccessApiUsageException("El número de tarjeta ya existe.");
        }


        if (isCardN) {
            throw new InvalidDataAccessApiUsageException("El nombre de la tarjeta ya existe. ");
        }
        cardResponse = cardBl.createCard(userid, cardRequest, transaction);


        return cardResponse;

    }

    @RequestMapping(value = "/{userid}/card/{cardid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public CardRequest editCard(@PathVariable("userid") Integer userid,@PathVariable("cardid") Integer cardId, @RequestBody CardRequest cardRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        CardRequest cardResponse = cardBl.editCard(cardRequest, cardId,userid, transaction);
        //CertificateRequest certificateResponse = certificateBl.createCertificate(1,certificateRequest, transaction);
        return cardResponse;
    }

    @RequestMapping(value = "/{userid}/card/{cardid}" ,method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Card deleteCard(@PathVariable("cardid") Integer certificateId, HttpServletRequest request) {
        // Creating transaction for this operation
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        // Executing the delete function in CertificateBl
        Card cardResponse=cardBl.deleteCard(certificateId,transaction);
        return cardResponse;
    }






}











