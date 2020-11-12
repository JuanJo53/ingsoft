package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.MediaDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.MediaRequest;
import bo.ucb.edu.ingsoft.model.Media;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MediaBl {
    private MediaDao mediaDao;
    private TransactionDao transactionDao;

    @Autowired
    public MediaBl(MediaDao mediaDao, TransactionDao transactionDao) {
        this.mediaDao = mediaDao;
        this.transactionDao = transactionDao;
    }

    public Media insertmedia(MediaRequest mediaRequest, Integer id, Transaction transaction){
        Media media = new Media();
        media.setProjectId(id);
        media.setCreationDate(new Date());
        media.setUrl(mediaRequest.getUrl());
        media.setTitle(mediaRequest.getTitle());
        media.setType(mediaRequest.getType());
        media.setTransaction(transaction);
        mediaDao.insertImage(media);
        return media;
    }

    public List<Media> getListMedia(Integer idproject) {
        return mediaDao.getMediaList(idproject);
    }
}
