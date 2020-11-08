package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProjectDao;
import bo.ucb.edu.ingsoft.dao.ProjectUserDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Project;
import bo.ucb.edu.ingsoft.model.ProjectUser;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectBl {
    private TransactionDao transactionDao;
    private ProjectDao projectDao;
    private ProjectUserDao projectUserDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateBl.class);


    @Autowired
    public ProjectBl(TransactionDao transactionDao, ProjectDao projectDao, ProjectUserDao projectUserDao) {
        this.transactionDao = transactionDao;
        this.projectDao = projectDao;
        this.projectUserDao = projectUserDao;
    }

    public ProjectRequest newproject(ProjectRequest projectRequest, Integer id,Transaction transaction){
       Project project =new Project();

       project.setProjectTitle(projectRequest.getProjectTitle());
       project.setDescription(projectRequest.getDescription());
       project.setAbilities(projectRequest.getAbilities());
       project.setBenefits(projectRequest.getBenefits());
       project.setViews(0);
       project.setStatus(projectRequest.getStatus());
       project.setCreate_date(new Date());

       project.setTransaction(transaction);

       projectDao.newProject(project);


        ProjectUser projectUser=new ProjectUser();
        projectUser.setUserId(id);
        projectUser.setProjectId(1);
        projectUser.setRol(1);
        projectUser.setStatus(1);
        projectUser.setTransaction(transaction);

        projectUserDao.newProjectUser(projectUser);

        return projectRequest;
    }
}
