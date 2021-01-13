package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CardDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.model.Card;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;


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


    public Boolean isCardName(Integer userId, String cardName) {
        Boolean resp=false;
        List<Card> listCard = cardDao.getCard(userId);
        for(Card card :listCard) {
            if(card.getCardName().equals(cardName)) {
                resp=true;
            }
        }
        return resp;
    }

    public Boolean isCardNumber(Integer userId, Long cardNumber) {
        Boolean resp=false;
        List<Card> listCard = cardDao.getCard(userId);
        for(Card card :listCard) {
            if(card.getCardNumber().toString().equals(cardNumber.toString())) {
                resp=true;
            }
        }
        return resp;
    }

}
