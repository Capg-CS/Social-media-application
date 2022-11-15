package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dao.*;
import com.model.*;

import com.exception.NoCommentFoundException;


@Component
public class CommentService {
	
	@Autowired
	CommentDAO commentdao;
	
	
	public void addCommentService(Comment comment) {
		commentdao.save(comment);
	}
	

	public void updateCommentService(Comment comment) {
		commentdao.save(comment);
	}


	public void deleteCommentService(Comment comment) {
		commentdao.delete(comment);
	}
	
	public Comment getCommentService(int id) throws NoCommentFoundException {
		
			Comment comment=commentdao.findById(id).get();
			
			if(comment!=null) {
				return comment;
			}
			else {
				throw new NoCommentFoundException("No Comment found");
			}
		
	}
	public List<Comment> getAllCommentService() {
        return commentdao.findAll();
    }
    
    public ResponseEntity addlikecommentservice(int commentId,Likes likes) throws NoCommentFoundException{
    	
    	try {
    		if(commentdao.findById(commentId)!=null) {
    		Comment comment=commentdao.findById(commentId).get();
            List<Likes> likeslist=comment.getLikes();
            likeslist.add(likes);
            comment.setLikes(likeslist);
            commentdao.save(comment);
            return new ResponseEntity("Comment Liked",HttpStatus.OK);
    		}
    		else {
    			throw new NoCommentFoundException("No Comment found");
    		}
    		
    	}
    	catch(NoCommentFoundException e) {
    		throw new NoCommentFoundException("No comment Found");
    	}
        
    }
	
}