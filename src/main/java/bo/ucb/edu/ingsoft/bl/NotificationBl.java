package bo.ucb.edu.ingsoft.bl;


import bo.ucb.edu.ingsoft.dao.NotificationDao;
import bo.ucb.edu.ingsoft.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationBl {
    private NotificationDao notificationDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPlanBl.class);


    @Autowired
    public NotificationBl(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    public Notification Notificationdetails(Integer notificationId){

        return notificationDao.detailsByNotificationId(notificationId);
    }
    public List<Notification> notificationList(Integer userId){
        return notificationDao.getNotification(userId);
    }


    public  Notification editstatus(Notification notification){
        notificationDao.UpdateStatus(notification);
        return notification;
    }
}
