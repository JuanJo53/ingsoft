package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.TagDao;
import bo.ucb.edu.ingsoft.dao.UserTagsDao;
import bo.ucb.edu.ingsoft.dto.TagRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.Tag;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.UserTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagBl {
    private TagDao tagDao;
    private UserTagsDao userTagsDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(TagBl.class);

    @Autowired
    public TagBl(TagDao tagDao, UserTagsDao userTagsDao) {
        this.tagDao = tagDao;
        this.userTagsDao = userTagsDao;
    }




    public Tag createNewTag(TagRequest tagRequest, Integer userid) {
        Tag tag=new Tag();

        tag.setNameTags(tagRequest.getTag());
        tag.setVerified(tagRequest.getVerified());
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
    public Tag getTagByName(String tagname) {
        Tag tag = tagDao.getByTagName(tagname);
        return tag;
    }
}
