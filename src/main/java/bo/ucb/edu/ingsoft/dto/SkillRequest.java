package bo.ucb.edu.ingsoft.dto;

public class SkillRequest {
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
