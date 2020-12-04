package bo.ucb.edu.ingsoft.dto;

public class AreaRequest {

    private String areaName;
    private Integer Status;


    public AreaRequest() {
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
