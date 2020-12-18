package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.AreaRequest;
import bo.ucb.edu.ingsoft.model.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {
    public void createArea(Area area);
    public Integer getLastIdArea();
    public void updateArea(Area area);
    public List<Area>getAreaByProject(Integer Idproject);
    public List<Area>findByAreaname(String namearea,Integer idproject);

}
