package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.UserTags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTagsDao {
    public void createUserTag(UserTags userTags);
    public void deletetag(Integer idtag, Integer iduser);
}
