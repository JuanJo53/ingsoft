package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardDao {
    public List<Card>getCard(Integer userId);
    public Card dataCardId(Integer cardId);
    public void newCard(Card card);
    public void updateCard(Card card);
    public void deleteCard(Card card);
}
