package bo.ucb.edu.ingsoft.bl;


import bo.ucb.edu.ingsoft.dao.AreaDao;
import bo.ucb.edu.ingsoft.dao.AreaProjectDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.AreaRequest;
import bo.ucb.edu.ingsoft.model.Area;
import bo.ucb.edu.ingsoft.model.AreaProject;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AreaBl {

    private AreaDao areaDao;
    private TransactionDao transactionDao;
    private AreaProjectDao areaProjectDao;


    private static final Logger LOGGER = LoggerFactory.getLogger(AreaBl.class);
    @Autowired
    public AreaBl(AreaDao areaDao, TransactionDao transactionDao, AreaProjectDao areaProjectDao) {
        this.areaDao = areaDao;
        this.transactionDao = transactionDao;
        this.areaProjectDao = areaProjectDao;
    }
    public Area createArea(AreaRequest areaRequest, Transaction transaction,Integer Idproject){
        Area area = new Area();
        LOGGER.info(areaRequest.getNameArea().toString());
        area.setNameArea(areaRequest.getNameArea());
        area.setTransaction(transaction);
        area.setCreationDate(new Date());
        LOGGER.info(area.toString());
        areaDao.createArea(area);

        AreaProject areaProject= new AreaProject();
        Integer areaid=areaDao.getLastIdArea();

        areaProject.setAreaId(areaid);
        areaProject.setProjectId(Idproject);
        areaProjectDao.createUserTag(areaProject);
        return area;
    }

    public List<Area> getAreaProjectlist(Integer Idproject){
        return areaDao.getAreaByProject(Idproject);
    }

    public Area editArea(AreaRequest areaRequest,Integer idarea){

        Area area = new Area();
        area.setAreaId(idarea);
        area.setNameArea(areaRequest.getNameArea());
        area.setStatus(areaRequest.getStatus());
        areaDao.updateArea(area);
        return area;
    }
}
