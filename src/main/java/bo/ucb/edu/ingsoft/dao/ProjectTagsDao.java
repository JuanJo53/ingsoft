package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.ProjectTags;
import bo.ucb.edu.ingsoft.model.Tag;
import bo.ucb.edu.ingsoft.model.UserTags;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectTagsDao {
    public void createProjectTag(ProjectTags projectTags);
    public void deletetagproject(Integer idtag, Integer idproject);

}



