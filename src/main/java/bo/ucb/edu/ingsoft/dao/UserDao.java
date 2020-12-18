package bo.ucb.edu.ingsoft.dao;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    //userId
    public void newUser(User user);
    public List<User> listproyectuser(Integer projectsId);
    public void updateUser(User user);
    public User findByUserId(Integer userId);
    public List<User> findByUsername(String username,Integer userId);
    public List<User>listproyectuserparticipan(Integer projectsId);
    public void updateImage(User user);
    public User findPersonByNP(User user);
}
