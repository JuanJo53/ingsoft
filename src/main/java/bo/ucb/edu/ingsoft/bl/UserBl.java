package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CertificateDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.dto.UserUpdate;
import bo.ucb.edu.ingsoft.model.Certificate;
import bo.ucb.edu.ingsoft.model.Project;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private UserDao userDao;
    private TransactionDao transactionDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBl.class);
    @Autowired
    public UserBl(UserDao userDao, TransactionDao transactionDao){
        this.userDao = userDao;
        this.transactionDao = transactionDao;
    }

    public UserRequest createNewUser(UserRequest userRequest, Transaction transaction) {
        User user =new User();

        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setTransaction(transaction);

        userDao.newUser(user);

        return  userRequest;
    }
    public User updateUser(UserUpdate userUpdate, Integer id, Transaction transaction){
        User user = new User();
        user.setUserId(id);
        user.setName(userUpdate.getName());
        user.setSurname(userUpdate.getSurname());
        user.setUsername(userUpdate.getUsername());
        user.setEmail(userUpdate.getEmail());
        user.setCellphone(userUpdate.getCellphone());
        user.setDescription(userUpdate.getDescription());
        user.setImage(userUpdate.getImage());
        userDao.updateUser(user);
        return user;
    }
    public User findByUserId (Integer id1){
        User user = userDao.findByUserId(id1);
        return user;
    }

}
