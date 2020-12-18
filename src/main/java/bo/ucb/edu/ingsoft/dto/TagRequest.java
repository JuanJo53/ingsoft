package bo.ucb.edu.ingsoft.dto;

import javax.validation.constraints.NotBlank;

public class TagRequest {
    @NotBlank(message = "NameTag is mandatory")
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
