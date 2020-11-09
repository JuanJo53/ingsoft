package bo.ucb.edu.ingsoft.model;

public class UserTags {
    private Integer userTagsId;
    private Integer userId;
    private Integer tagsId;

    public UserTags() {
    }

    public Integer getUserTagsId() {
        return userTagsId;
    }

    public void setUserTagsId(Integer userTagsId) {
        this.userTagsId = userTagsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTagsId() {
        return tagsId;
    }

    public void setTagsId(Integer tagsId) {
        this.tagsId = tagsId;
    }
}
