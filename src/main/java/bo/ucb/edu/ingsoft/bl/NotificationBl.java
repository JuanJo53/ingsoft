package bo.ucb.edu.ingsoft.bl;


import bo.ucb.edu.ingsoft.dao.NotificationDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.dto.NotificationRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Notification;
import bo.ucb.edu.ingsoft.model.Transaction;
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

    public NotificationRequest Notificationdetails(Integer userid,Integer notificationId){
        return notificationDao.detailsByNotificationId(userid,notificationId);
    }
    public NotificationRequest createNotification(Integer userId, NotificationRequest notificationRequest, Transaction transaction) {
        Notification notification = new Notification();
        //Setting all the data sent from the body in CertificateRequest to the certificate class.
        notification.setUserId(userId);
        notification.setProjectId(notificationRequest.getProjectId());
        notification.setTitle(notificationRequest.getTitle());
        notification.setMessage(notificationRequest.getMessage());
        notification.setDate(notificationRequest.getDate());
        notification.setStatus(2);   //unseen = 2: UNSEEN CERTIFICATE
        //setting the last transaction data
        notification.setTransaction(transaction);
        //Executing insert function to certificateDao
        notificationDao.newNotification(notification);

        return  notificationRequest;
    }
    public List<Notification> notificationList(Integer userId){
        return notificationDao.getNotification(userId);
    }

    public void markSeenNotification(Integer userId, Integer notificationId){
        notificationDao.updateStatus(userId, notificationId);
    }
}
