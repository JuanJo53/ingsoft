package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class Card {

        private Integer cardId;
        private Integer userId;
        private String cardName;
        private Integer expirationYear;
        private Integer expirationMonth;
        private String userName;
        private String userSurname;
        private Integer CVC;
        private Date creationDate;
        private Transaction transaction;

        public Card() {
            transaction=new Transaction();
        }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Integer getCVC() {
        return CVC;
    }

    public void setCVC(Integer CVC) {
        this.CVC = CVC;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", userId=" + userId +
                ", cardName='" + cardName + '\'' +
                ", expirationYear=" + expirationYear +
                ", expirationMonth=" + expirationMonth +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", CVC=" + CVC +
                ", creationDate=" + creationDate +
                ", transaction=" + transaction +
                '}';
    }
}
