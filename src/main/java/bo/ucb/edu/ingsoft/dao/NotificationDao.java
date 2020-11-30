package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.NotificationRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationDao {
    public NotificationRequest detailsByNotificationId(Integer userId, Integer notificationId);
    public void newNotification(Notification notification);
    public List<Notification> getNotification(Integer userId);
    public void updateStatus(Integer userId, Integer notificationId);
}
