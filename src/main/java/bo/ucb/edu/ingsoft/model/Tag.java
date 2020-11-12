package bo.ucb.edu.ingsoft.model;

public class Tag {
    private Integer tagId;
    private String nameTags;
    private Integer verified;
    private Integer status;
    private Transaction transaction;

    public Tag() {transaction=new Transaction();}

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", nameTags='" + nameTags + '\'' +
                ", verified=" + verified +
                '}';
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getNameTags() {
        return nameTags;
    }

    public void setNameTags(String nameTags) {
        this.nameTags = nameTags;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
