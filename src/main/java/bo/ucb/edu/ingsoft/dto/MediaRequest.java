package bo.ucb.edu.ingsoft.dto;

import java.sql.Blob;

public class MediaRequest {
    private String title;
    private String  url;
    private Integer type;

    public MediaRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
