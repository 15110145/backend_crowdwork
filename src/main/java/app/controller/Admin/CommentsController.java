package app.controller.Admin;

import app.model.Comments;
import app.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    //show List
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<Comments> getCommentsList() {
        ArrayList<Comments> list = commentsService.findAll();
        return list;
    }

    //Find particular
    @RequestMapping(value = "/{commentsId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<Comments> getComments(@PathVariable("commentsId") String commentsId) {
        return commentsService.getComments(Integer.valueOf(commentsId));
    }

    //Add
    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Comments addComments(@RequestBody Comments comments) {

        System.out.println("(Service Side) Creating: " + comments.getId());
        commentsService.addComments(comments);
        return comments;
    }

    //Edit
    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Comments updateComments(@RequestBody Comments comments) {

        System.out.println("(Service Side) Editing: " + comments.getId());
        commentsService.editComments(comments);
        return comments;
    }

    //Delete
    @RequestMapping(value = "/{commentsId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteComments(@PathVariable("commentsId") String commentsId) {

        System.out.println("(Service Side) Deleting: " + commentsId);

        commentsService.deleteComments(Integer.valueOf(commentsId));
    }
}
