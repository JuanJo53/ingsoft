package bo.ucb.edu.ingsoft.dto;

public class TagRequest {
    private String tag;
    private Integer verified;

    public TagRequest() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }
}
