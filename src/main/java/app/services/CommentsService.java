package app.services;

import app.model.Comments;
import app.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;

    public ArrayList<Comments> findAll()
    {
        ArrayList<Comments> lstComments = new ArrayList<>();
        lstComments.addAll(commentsRepository.findAll());
        return lstComments;
    }

    public Optional<Comments> getComments(Integer commentsId)
    {
        return commentsRepository.findById(commentsId);
    }

    public void addComments(Comments comments)
    {
        comments.setDelFlag(Boolean.FALSE);
        commentsRepository.save(comments);
    }

    public void editComments(Comments editedComments)
    {
        Optional<Comments> optionalComments = getComments(editedComments.getId());
        if(optionalComments.isPresent()) {
            Comments comments = optionalComments.get();
            if (editedComments.getContent() != null){
                comments.setContent(editedComments.getContent());
            }
            if (editedComments.getDelFlag() != null){
                comments.setDelFlag(editedComments.getDelFlag());
            }
            if (editedComments.getJobs() != null){
                comments.setJobs(editedComments.getJobs());
            }
            if (editedComments.getParentId() != null){
                comments.setParentId(editedComments.getParentId());
            }
            if (editedComments.getUsers() != null){
                comments.setUsers(editedComments.getUsers());
            }
            commentsRepository.save(comments);
        }
        else
        {

        }
        //commentsRepository.save(editedComments);
    }

    public void deleteComments(Integer commentsId)
    {
        Optional<Comments> optionalComments = getComments(commentsId);
        if(optionalComments.isPresent()) {
            Comments comments = optionalComments.get();
            comments.setDelFlag(Boolean.TRUE);
            commentsRepository.save(comments);
        }
        else
        {

        }
    }
}
