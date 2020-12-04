package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.ProjectTags;
import bo.ucb.edu.ingsoft.model.UserTags;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ProjectTagsDao {
    public void createProjectTag(ProjectTags projectTags);
    public void deletetag(Integer idtag, Integer idproject);
}



