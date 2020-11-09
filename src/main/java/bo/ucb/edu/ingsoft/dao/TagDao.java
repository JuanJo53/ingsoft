package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Tag;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TagDao {

    public void createTag(Tag tag);
    public Integer getLastIdTag();
    public Tag getByTagName(String tagName);

}
