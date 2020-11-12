package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.NotificationBl;
import bo.ucb.edu.ingsoft.dto.NotificationRequest;
import bo.ucb.edu.ingsoft.dto.ProjectRequest;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Notification;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user/notification")
public class NotificationApi {

    private NotificationBl notificationBl;
    @Autowired
    public NotificationApi(NotificationBl notificationBl) {
        this.notificationBl = notificationBl;
    }

    @RequestMapping(value = "/{notificationid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Notification getnotification( HttpServletRequest request,@PathVariable("notificationid") Integer Id) {

        return notificationBl.Notificationdetails(Id);
    }
    @RequestMapping(value = "/list/{userid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Notification> getnotificationlist(HttpServletRequest request, @PathVariable("userid") Integer Id) {

        return notificationBl.notificationList(Id);
    }



    @RequestMapping(value = "/update/{idnotification}/{status}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE )
    public Notification editproyect(@PathVariable("idnotification") Integer id,@PathVariable("status") Integer status, HttpServletRequest request) {


        Transaction transaction = TransactionUtil.createTransaction(request);
        Notification notification=new Notification() ;
        notification.setNotificationId(id);
        notification.setStatus(status);
        notificationBl.editstatus(notification);

        return notification;
    }

}
