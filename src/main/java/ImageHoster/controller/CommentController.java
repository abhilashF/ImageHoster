package ImageHoster.controller;

import ImageHoster.model.Comment;

import ImageHoster.model.User;
import ImageHoster.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    //The method receives all the comments to be stored in the database, and now the comment will be sent to the business logic to be persisted in the database
    //After you get the text, set the user of the text by getting the logged in user from the Http Session
    //After storing the comment, this method directs to the image's page  displaying all the details of the image.

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createComment(@RequestParam("text" )String text,Comment newComment, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("loggeduser");
        newComment.setText(text);
        newComment.setUser(user);
        commentService.createComment(newComment);

        return "ImageController/showImage()";
    }
}