package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.TagBl;

import bo.ucb.edu.ingsoft.dto.TagRequest;
import bo.ucb.edu.ingsoft.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tags")
public class TagApi {
    private TagBl tagBl;

    @Autowired
    public TagApi(TagBl tagBl) {
        this.tagBl = tagBl;
    }

    @RequestMapping(value="/createTag/{userid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tag createnewtag(@RequestBody TagRequest tagRequest, @PathVariable("userid") Integer id) {
        Tag tagResponse = tagBl.createNewTag(tagRequest,id);
        return tagResponse;
    }
    @RequestMapping(value = "/{tagname}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tag gettag( @PathVariable("tagname") String tag) {
        Tag tagNameResponse = tagBl.getTagByName(tag);
        return tagNameResponse;
    }
}
