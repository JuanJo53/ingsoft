package bo.ucb.edu.ingsoft.dao;
import bo.ucb.edu.ingsoft.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public void newUser(User user);
    public List<User> listproyectuser(Integer projectsId);
    public void updateUser(User user);
    public User findByUserId(Integer userId);

}
