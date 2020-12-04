package bo.ucb.edu.ingsoft.model;

public class AreaProject {

    private Integer ProjectAreaId;
    private Integer AreaId;
    private Integer ProjectId;

    public AreaProject() {
    }

    @Override
    public String toString() {
        return "AreaProject{" +
                "ProjectAreaId=" + ProjectAreaId +
                ", AreaId=" + AreaId +
                ", ProjectId=" + ProjectId +
                '}';
    }

    public Integer getProjectAreaId() {
        return ProjectAreaId;
    }

    public void setProjectAreaId(Integer projectAreaId) {
        ProjectAreaId = projectAreaId;
    }

    public Integer getAreaId() {
        return AreaId;
    }

    public void setAreaId(Integer areaId) {
        AreaId = areaId;
    }

    public Integer getProjectId() {
        return ProjectId;
    }

    public void setProjectId(Integer projectId) {
        ProjectId = projectId;
    }
}
