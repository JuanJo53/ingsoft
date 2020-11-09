package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProjectDao;
import bo.ucb.edu.ingsoft.dao.ProjectUserDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectBl {
    private TransactionDao transactionDao;
    private ProjectDao projectDao;
    private ProjectUserDao projectUserDao;
    private UserDao userDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateBl.class);


    @Autowired
    public ProjectBl(TransactionDao transactionDao, ProjectDao projectDao, ProjectUserDao projectUserDao,UserDao userDao) {
        this.transactionDao = transactionDao;
        this.projectDao = projectDao;
        this.projectUserDao = projectUserDao;
        this.userDao=userDao;
    }

    public ProjectRequest newproject(ProjectRequest projectRequest, Integer id,Transaction transaction){
       Project project =new Project();

       project.setProjectTitle(projectRequest.getProjectTitle());
       project.setDescription(projectRequest.getDescription());
       project.setAbilities(projectRequest.getAbilities());
       project.setBenefits(projectRequest.getBenefits());
       project.setViews(0);
       project.setStatus(projectRequest.getStatus());
       project.setCreateDate(new Date());

       project.setTransaction(transaction);

       projectDao.newProject(project);


        ProjectUser projectUser=new ProjectUser();
        projectUser.setUserId(id);
        projectUser.setProjectId(projectDao.getLastInsertIdProject());
        projectUser.setRol(1);
        projectUser.setStatus(1);
        projectUser.setTransaction(transaction);

        projectUserDao.newProjectUser(projectUser);

        return projectRequest;
    }
    public ProjectRequest editproject(ProjectRequest projectRequest,
                                      Integer id,Transaction transaction) {
        Project project =new Project();

        project.setProjectsId(id);
        project.setProjectTitle(projectRequest.getProjectTitle());
        project.setDescription(projectRequest.getDescription());
        project.setAbilities(projectRequest.getAbilities());
        project.setBenefits(projectRequest.getBenefits());
        project.setStatus(projectRequest.getStatus());
        project.setViews(0);
        projectDao.updateproyect(project);

        return projectRequest;
    }

    public Project detailsByprojectId(Integer projectid) {
        Project p=projectDao.detailsproyect(projectid);
        LOGGER.error(p.getAbilities());
        return  projectDao.detailsproyect(projectid);
    }


    public List<Project>listproyect(){
        return  projectDao.listproyect();
    }

    public List<Project>listproyectuser(Integer idUser){
        return  projectDao.listproyectuser(idUser);
    }

    public List<User>listUserProject(Integer idproject){

        return userDao.listproyectuser(idproject);
    }
}