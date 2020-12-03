package bo.ucb.edu.ingsoft.dto;

public class TagRequest {
    private String nameTags;
    private Integer verified;

    public TagRequest() {
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
