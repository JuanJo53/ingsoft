package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CardDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.model.Card;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CardBl {

    private CardDao cardDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CardBl.class);

    @Autowired
    public CardBl(CardDao cardDao, TransactionDao transactionDao) {
        this.cardDao = cardDao;
        this.transactionDao = transactionDao;
    }

    public Card getCardDetails(Integer userid, Integer cardid) {
        return cardDao.dataCardId(cardid);
    }

    //Function that gets all user certificates
    public List<Card> getCardBasicData(Integer userId) {
        return cardDao.getCard(userId);
    }

    public CardRequest createCard(Integer userId, CardRequest cardRequest, Transaction transaction) {
        validationCard(cardRequest);


        Card card = new Card();


        LOGGER.error(cardRequest.getCreationDate().toString());

        card.setUserId(userId);
        card.setCardName(cardRequest.getCardName());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setExpirationYear(cardRequest.getExpirationYear());
        card.setExpirationMonth(cardRequest.getExpirationMonth());
        card.setCvc(cardRequest.getCvc());
        card.setCreationDate(cardRequest.getCreationDate());
        card.setStatus(1);
        card.setTransaction(transaction);
        cardDao.newCard(card);
        return cardRequest;
    }

    public CardRequest editCard(CardRequest cardRequest, Integer cardId, Integer userid, Transaction transaction) {
        validationCard(cardRequest);
        Card card = new Card();
        card.setCardId(cardId);
        card.setCardName(cardRequest.getCardName());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setExpirationYear(cardRequest.getExpirationYear());
        card.setExpirationMonth(cardRequest.getExpirationMonth());
        card.setCvc(cardRequest.getCvc());
        card.setCreationDate(new Date());
        card.setStatus(1);
        card.setTransaction(transaction);
        cardDao.updateCard(card);
        return cardRequest;
    }

    public Card deleteCard(Integer cardId, Transaction transaction) {

        Card card = new Card();

        LOGGER.info("Deleting card");
        card.setCardId(cardId);
        card.setStatus(0);
        LOGGER.info("Card deleted succesfuly");
        card.setTransaction(transaction);
        cardDao.deleteCard(card);
        return card;
    }


    private void validationCard(CardRequest cardRequest) {
        int min_length = 5;
        int max_length = 20;
        String regex_name = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]{0,}";
        Pattern pattern = Pattern.compile(regex_name);
        Matcher matcher = pattern.matcher(cardRequest.getCardName());
        if (!matcher.matches()) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "El nombre de la tarjeta no admite números ni caracteres especiales.");
        }
        if (cardRequest.getCardName().trim().length() < min_length) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, String.format("El nombre de la tarjeta debe ser mayor a %d caracteres.", min_length));
        }
        if (cardRequest.getCardName().trim().length() > max_length) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, String.format("El nombre de la tarjeta debe ser menor a %d caracteres.", max_length));
        }

        int digitos = (int) (Math.log10(cardRequest.getCardNumber()) + 1);
        if (cardRequest.getCardNumber() < 0 || digitos < 14 || digitos > 16) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Número de tarjeta incorrecto.");
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        if (cardRequest.getExpirationYear() < year) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, String.format("El año de expiración no debe ser menor a la fecha actual.", max_length));
        }

        if (cardRequest.getExpirationMonth() < 1 || cardRequest.getExpirationMonth() > 12) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Mes de expiración incorrecto.");
        }
        int month = cal.get(Calendar.MONTH);
        if (cardRequest.getExpirationYear() == year && cardRequest.getExpirationMonth() <= month) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, String.format("El mes de expiración no debe ser menor de la fecha actual %d.", month));
        }

        digitos = (int) (Math.log10(cardRequest.getCvc()) + 1);
        if (digitos < 3 || digitos > 4) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "CVC incorrecto.");
        }

        if (cardRequest.getCreationDate().before(new Date())) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Fecha de creación incorrecta.");
        }
    }
}
