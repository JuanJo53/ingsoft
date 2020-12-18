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
    public void increaseProjectViews(Integer userid,Integer projectsId);
    public List<Project> listproyect();
    public List<Project> listproyectuser(Integer UserId);
    public Integer getLastInsertIdProject();
    public List<Project> listproyectuserparticipate(Integer UserId);
    public Project proyectuser(Integer UserId,Integer projectsId);
    public List<Project>listproyectag(Integer Tagsid);

    public List<Project>listproyecserch(String serch);
}
