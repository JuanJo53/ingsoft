package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.bl.UserBl;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.dto.UserUpdate;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserApi {

    private UserBl userBl;
    private TransactionBl transactionBl;

    @Autowired
    public UserApi(UserBl userBl, TransactionBl transactionBl) {
        this.userBl = userBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserRequest createnewuser(@Valid @RequestBody UserRequest userRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        UserRequest userResponse = userBl.createNewUser(userRequest, transaction);
        return userResponse;
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateuser(@PathVariable("userid") Integer id,@Valid  @RequestBody UserUpdate userUpdate, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        User userResponse = userBl.updateUser(userUpdate, id,transaction);
        return userResponse;
    }

    @RequestMapping(value = "/{userid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findbyuserid(@PathVariable("userid") Integer id){
        return  userBl.findByUserId(id);
    }

    @RequestMapping(value = "/{userid}/image", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateimage(@PathVariable("userid") Integer id, @RequestBody UserUpdate userUpdate, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        User userResponse = userBl.updateimage(userUpdate, id,transaction);
        return userResponse;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody User user1, HttpServletRequest request) {
        User user = userBl.login(user1);
        return user;
    }
}
