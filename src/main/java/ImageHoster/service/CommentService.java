package ImageHoster.service;
import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    //The method calls the createCommetn() method in the Repository and passes the comment to be persisted in the database
        @Autowired
    private CommentRepository commentRepository;

    public  void createComment(Comment comment){

         commentRepository.createComment(comment);
    }

}
