package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProjectTagsDao;
import bo.ucb.edu.ingsoft.dao.TagDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.UserTagsDao;
import bo.ucb.edu.ingsoft.dto.TagRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagBl {
    private TagDao tagDao;
    private UserTagsDao userTagsDao;
    private TransactionDao transactionDao;
    private ProjectTagsDao projectTagsDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(TagBl.class);

    @Autowired
    public TagBl(TagDao tagDao, UserTagsDao userTagsDao, TransactionDao transactionDao, ProjectTagsDao projectTagsDao) {
        this.tagDao = tagDao;
        this.userTagsDao = userTagsDao;
        this.projectTagsDao = projectTagsDao;
        this.transactionDao = transactionDao;
    }




    public Tag createNewTag(TagRequest tagRequest, Integer userid, Transaction transaction) {
        Tag tag=new Tag();

        tag.setNameTags(tagRequest.getNameTags());
        tag.setVerified(tagRequest.getVerified());
        tag.setTransaction(transaction);
        LOGGER.info("idtag: "+tag.getNameTags());
       if(tag.getNameTags().trim().length()==0){
           return null;
       }
       else{
           tagDao.createTag(tag);
           Integer tagid = tagDao.getLastIdTag();
           LOGGER.info("idtag: "+tagid);

           UserTags usertag= new UserTags();
           usertag.setUserId(userid);
           usertag.setTagsId(tagid);
           LOGGER.info(usertag.toString());
           userTagsDao.createUserTag(usertag);

           return tag;

       }

    }

    public Tag getTagByName(String tagname) {
        Tag tag = tagDao.getByTagName(tagname);
        return tag;
    }
    public List<Tag> getAllVerifiedTags(){
        return tagDao.getVerifiedTags();
    }
    public List<Tag> getusertag(Integer id){
        return tagDao.getUserTag(id);
    }
    public void deletetag(Integer idtag,Integer iduser){
        userTagsDao.deletetag(idtag,iduser);
    }
    public void deletetagproject(Integer idtag,Integer idproject){
        projectTagsDao.deletetagproject(idtag,idproject);
    }
    public Tag addTagToUser(Tag tag, Integer id) {
        UserTags tag1=new UserTags();
        tag1.setTagsId(tag.getTagId());
        tag1.setUserId(id);
        userTagsDao.createUserTag(tag1);
        return tag;
    }
    public Tag addTagToProject(TagRequest tagRequest, Integer id, Transaction transaction){
        Tag tag1= new Tag();
        tag1.setNameTags(tagRequest.getNameTags());
        tag1.setVerified(tagRequest.getVerified());
        tag1.setTransaction(transaction);
        if(tag1.getNameTags().trim().length()==0){
            return null;
        }
        else{
            tagDao.createTag(tag1);
            Integer tagid = tagDao.getLastIdTag();
            ProjectTags projectTags= new ProjectTags();
            projectTags.setProjectsId(id);
            projectTags.setTagsId(tagid);
            projectTagsDao.createProjectTag(projectTags);
            return tag1;
        }

    }
    public Tag addToProject(Tag tag, Integer id) {
        ProjectTags tag1=new ProjectTags();
        tag1.setTagsId(tag.getTagId());
        tag1.setProjectsId(id);
        projectTagsDao.createProjectTag(tag1);
        return tag;
    }
    public List<Tag> getAllProjectTags(Integer idproject){
        return tagDao.listTagProject(idproject);
    }
}
