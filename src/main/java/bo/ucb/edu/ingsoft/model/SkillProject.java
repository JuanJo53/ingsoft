package bo.ucb.edu.ingsoft.model;

public class SkillProject {

    Integer ProjectSkillId;
    Integer SkillId;
    Integer ProjecteId;

    public SkillProject() {
    }

    public Integer getProjectSkillId() {
        return ProjectSkillId;
    }

    public void setProjectSkillId(Integer projectSkillId) {
        ProjectSkillId = projectSkillId;
    }

    public Integer getSkillId() {
        return SkillId;
    }

    public void setSkillId(Integer skillId) {
        SkillId = skillId;
    }

    public Integer getProjecteId() {
        return ProjecteId;
    }

    public void setProjecteId(Integer projecteId) {
        ProjecteId = projecteId;
    }
}
