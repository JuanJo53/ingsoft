package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationDao {
     public Notification detailsByNotificationId(Integer notificationId);
    public List<Notification> getNotification(Integer userId);
}
