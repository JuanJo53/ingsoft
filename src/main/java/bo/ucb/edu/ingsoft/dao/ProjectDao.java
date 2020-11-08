package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectDao {
    //detailsproyect
    public void newProject(Project project);
    public void updateproyect(Project project);
    public Project detailsproyect(Integer projectsId);
    //listproyectuser
    public List<Project> listproyect();
    public List<Project> listproyectuser(Integer UserId);
    //getLastInsertIdProject
    public Integer getLastInsertIdProject();
}
