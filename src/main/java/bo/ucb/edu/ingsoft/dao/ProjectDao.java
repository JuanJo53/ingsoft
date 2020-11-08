package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Project;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectDao {
    public void newProject(Project project);

}
