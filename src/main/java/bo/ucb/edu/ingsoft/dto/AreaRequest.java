package bo.ucb.edu.ingsoft.dto;

import javax.validation.constraints.NotBlank;

public class AreaRequest {

    @NotBlank(message = "Name is mandatory")
    private String nameArea;
    private Integer Status;


    public AreaRequest() {
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
