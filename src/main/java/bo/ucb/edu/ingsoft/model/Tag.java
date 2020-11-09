package bo.ucb.edu.ingsoft.model;

public class Tag {
    private Integer tagId;
    private String nameTags;
    private Integer verified;

    public Tag() {
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
}
