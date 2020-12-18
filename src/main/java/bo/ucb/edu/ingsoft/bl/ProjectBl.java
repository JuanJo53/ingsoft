package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.*;
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
    private NotificationDao notificationDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificateBl.class);


    @Autowired
    public ProjectBl(TransactionDao transactionDao, ProjectDao projectDao, ProjectUserDao projectUserDao,UserDao userDao,NotificationDao notificationDao) {
        this.transactionDao = transactionDao;
        this.projectDao = projectDao;
        this.projectUserDao = projectUserDao;
        this.userDao=userDao;
        this.notificationDao=notificationDao;
    }

    public ProjectRequest newproject(ProjectRequest projectRequest, Integer id,Transaction transaction){
       Project project =new Project();

       project.setProjectTitle(projectRequest.getProjectTitle().trim());
       project.setDescription(projectRequest.getDescription());
       project.setBenefits(projectRequest.getBenefits());
       project.setViews(0);
       project.setStatus(projectRequest.getStatus());
       project.setCreateDate(new Date());
       project.setTransaction(transaction);
       if(project.getBenefits().trim().length()==0 || project.getDescription().trim().length()==0 || project.getProjectTitle().trim().length()==0){
           return null;
       }else{
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

    }
    public ProjectRequest editproject(ProjectRequest projectRequest, Integer idproject,Transaction transaction) {
        Project project =new Project();

        project.setProjectsId(idproject);
        project.setProjectTitle(projectRequest.getProjectTitle().trim());
        project.setDescription(projectRequest.getDescription());
        project.setBenefits(projectRequest.getBenefits());
        project.setStatus(projectRequest.getStatus());
        if(project.getBenefits().trim().length()==0 || project.getDescription().trim().length()==0 || project.getProjectTitle().trim().length()==0){
            return null;
        }else{
            projectDao.updateproyect(project);
            return projectRequest;
        }
    }
    public ProjectRequest increaseViews(ProjectRequest projectRequest,Integer userid,Integer id,Transaction transaction) {
        projectDao.increaseProjectViews(userid,id);
        return projectRequest;
    }
    public Integer conexion(Integer usid,Integer prid){
        if(projectDao.proyectuser(usid,prid)==null){
            return 2;
        }else {
            return 1;
        }
    }
    public void editprojectrollwaitingtoacept(Integer iduser, Integer idproject, Transaction transaction) {

        ProjectUser projectUser=new ProjectUser();
        projectUser.setUserId(iduser);
        projectUser.setProjectId(idproject);
        projectUser.setRol(3);
        projectUser.setStatus(1);
        projectUserDao.updatestatus(projectUser);

        Notification notification = new Notification();
        notification.setTitle("Acepto tu solicitud");
        notification.setMessage("El dueño del proyecto acepto tu solicitud para unirte a su proyecto.");
        notification.setUserId(iduser);
        notification.setProjectId(idproject);
        notification.setStatus(2);
        notification.setTransaction(transaction);

        LOGGER.info(String.valueOf(notification));
        notificationDao.newNotification(notification);

    }
    public void editprojectrollwaitingtoreject (Integer iduser, Integer idproject) {

        ProjectUser projectUser=new ProjectUser();
        projectUser.setUserId(iduser);
        projectUser.setProjectId(idproject);
        projectUser.setRol(0);
        projectUser.setStatus(1);
        projectUserDao.updatestatus(projectUser);

    }

    public void editprojectask(Integer iduser, Integer idproject,Transaction transaction) {

        ProjectUser projectUser=new ProjectUser();
        projectUser.setUserId(iduser);
        projectUser.setProjectId(idproject);
        projectUser.setRol(2);
        projectUser.setStatus(1);
        projectUser.setTransaction(transaction);
        projectUserDao.newProjectUser(projectUser);

        //Enviar notificacion a dueño de proyecto
        Notification notification = new Notification();
        notification.setTitle("Nueva Solicitud");
        notification.setMessage("Un usuario solicito unirse a tu proyecto");
        //pendiente
        notification.setUserId(projectUserDao.getuserowner(idproject));
        notification.setProjectId(idproject);
        notification.setStatus(2);
        notification.setTransaction(transaction);

        LOGGER.info(String.valueOf(notification));
        notificationDao.newNotification(notification);
    }

    public Project detailsByprojectId(Integer projectid) {
//        Project p=projectDao.detailsproyect(projectid);
//        LOGGER.error(p.getAbilities());
        return  projectDao.detailsproyect(projectid);
    }


    public List<Project>listproyect(){
        return  projectDao.listproyect();
    }

    public List<Project>listproyecttag(Integer idtag){
        return  projectDao.listproyectag(idtag);
    }
    public List<Project>listproyecserche(String  buscar){
        return  projectDao.listproyecserch(buscar);
    }
    public List<Project>listproyectuser(Integer idUser){
        return  projectDao.listproyectuser(idUser);
    }

    public List<Project>listproyectuserparticioate(Integer idUser){
        return  projectDao.listproyectuserparticipate(idUser);
    }

    public List<User>listUserProject(Integer idproject){

        return userDao.listproyectuser(idproject);
    }

    public List<User>listUserProjectparticipate(Integer idproject){

        return userDao.listproyectuserparticipan(idproject);
    }
}
