package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Project;
import bo.ucb.edu.ingsoft.model.ProjectUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectUserDao {

    public void newProjectUser(ProjectUser projectUser);
    public void updatestatus(ProjectUser projectUser);
    public Integer getuserowner(Integer idproject);
}
