package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CardDao;
import bo.ucb.edu.ingsoft.dao.CertificateDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.model.Card;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Card detailsByCardId(Integer cardId) {
        return cardDao.dataCardId(cardId);
    }

    //Function that gets all user certificates
    public List<Card> getCardBasicData(Integer userId) {
        return  cardDao.getCard (userId);
    }

    public CardRequest createCard(Integer userId, CardRequest cardRequest, Transaction transaction) {
        Card card = new Card();


        LOGGER.error(cardRequest.getCreationDate().toString());

        card.setUserId(userId);
        card.setCardName(cardRequest.getCardName());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setExpirationYear(cardRequest.getExpirationYear());
        card.setExpirationMonth(cardRequest.getExpirationMonth());
        card.setUserName(cardRequest.getUserName());
        card.setUserSurname(cardRequest.getUserSurname());
        card.setCvc(cardRequest.getCvc());
        card.setCreationDate(cardRequest.getCreationDate());
        card.setTransaction(transaction);
        cardDao.newCard(card);
        return cardRequest;
    }
    public CardRequest editCard(CardRequest cardRequest, Integer cardId, Transaction transaction) {
        Card card = new Card();
        card.setCardId(cardId);
        card.setCardName(cardRequest.getCardName());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setExpirationYear(cardRequest.getExpirationYear());
        card.setExpirationMonth(cardRequest.getExpirationMonth());
        card.setUserName(cardRequest.getUserName());
        card.setUserSurname(cardRequest.getUserSurname());
        card.setCvc(cardRequest.getCvc());
        card.setCreationDate(cardRequest.getCreationDate());
        card.setTransaction(transaction);
        cardDao.updateCard(card);
        return  cardRequest;
    }

}
