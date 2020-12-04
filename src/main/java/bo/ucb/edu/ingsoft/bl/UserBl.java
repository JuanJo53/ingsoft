package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CertificateDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dto.CertificateRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.dto.UserUpdate;
import bo.ucb.edu.ingsoft.model.*;
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
    public UserRequest findByUserId (Integer id1){
        UserRequest user = userDao.findByUserId(id1);
        return user;
    }
    public User updateimage(UserUpdate userUpdate,Integer iduser,Transaction transaction) {
        User user1 = new User();
        user1.setUserId(iduser);
        user1.setImage(userUpdate.getImage());
        userDao.updateImage(user1);
        return user1;
    }
    public User login(User user){
        User user1= new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        User user2= new User();
        if (userDao.findPersonByNP(user1)!=null){
            return userDao.findPersonByNP(user1);
        }else{
            return user2;
        }


    }

}
