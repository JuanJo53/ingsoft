package bo.ucb.edu.ingsoft.dto;

import javax.validation.constraints.NotBlank;

public class SkillRequest {
    @NotBlank(message = "Name is mandatory")
    private String skillName;
    private Integer verified;


    public SkillRequest() {
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }


}
