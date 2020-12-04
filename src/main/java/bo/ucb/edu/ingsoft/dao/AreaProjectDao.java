package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.AreaProject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AreaProjectDao {
    public void createUserTag(AreaProject areaProject);
}
