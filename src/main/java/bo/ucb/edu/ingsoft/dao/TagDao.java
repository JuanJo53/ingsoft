package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TagDao {

    public void createTag(Tag tag);
    public Integer getLastIdTag();
    public Tag getByTagName(String tagName);
    public List<Tag> getVerifiedTags();
    public List<Tag> getUserTag(Integer iduser);
    public List<Tag> listTagProject(Integer idproject);
}
