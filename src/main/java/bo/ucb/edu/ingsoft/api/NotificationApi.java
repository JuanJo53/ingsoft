package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.NotificationBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
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
@RequestMapping(value = "/user")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotificationApi {

    private NotificationBl notificationBl;
    private TransactionBl transactionBl;
    @Autowired
    public NotificationApi(NotificationBl notificationBl, TransactionBl transactionBl) {
        this.notificationBl = notificationBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/{userid}/notifications/{notificationid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public NotificationRequest getnotification( HttpServletRequest request,@PathVariable("userid") Integer userId,@PathVariable("notificationid") Integer notificationId) {
        return notificationBl.Notificationdetails(userId,notificationId);
    }
    @RequestMapping(value = "/{userid}/notifications" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public NotificationRequest createNotification(@PathVariable("userid") Integer userid, @RequestBody NotificationRequest notificationRequest, HttpServletRequest request) {
        // Creating transaction for this operation
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        // Executing the update function in CertificateBl
        NotificationRequest notificationResponse = notificationBl.createNotification(userid,notificationRequest, transaction);
        return notificationResponse;
    }
    @RequestMapping(value = "/{userid}/notifications" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Notification> getnotificationlist(HttpServletRequest request, @PathVariable("userid") Integer userId) {
        return notificationBl.notificationList(userId);
    }
    @RequestMapping(value = "/{userid}/notifications/{notificationid}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE )
    public void editProyect(@PathVariable("userid") Integer userId,@PathVariable("notificationid") Integer notificationId,HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        notificationBl.markSeenNotification(userId,notificationId);
    }
}
