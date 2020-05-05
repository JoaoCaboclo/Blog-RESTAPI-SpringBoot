package com.joaocaboclosf.blog.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.joaocaboclosf.blog.model.Comment;
import com.joaocaboclosf.blog.model.Comment;
import com.joaocaboclosf.blog.repository.CommentRepository;
import com.joaocaboclosf.blog.util.ResourceNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/comments")

public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Comment createComment(@RequestBody Comment Comment) {
		
		return commentRepository.save(Comment);
	}
	
	//   Como chamar no browse - http://localhost:8085/Comments
	@GetMapping("")
	public List<Comment> listComments() {
		return commentRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Comment getComment(@PathVariable("id") Integer id) {
		
		return commentRepository.findById(id).orElseThrow( ()->
		new ResourceNotFoundException("Nenhuma Commentagem encontrada com o id="+id));
	}

	@PutMapping("/{id}")
	public Comment updateComment(@PathVariable("id") Integer id, @RequestBody Comment Comment) {
		
		commentRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Nenhuma Commentagem encontrada com o id="+id));
		return commentRepository.save(Comment);
	}

	@DeleteMapping("/{id}")
	public void deleteComment(@PathVariable("id") Integer id) {
		
		Comment Comment = commentRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Nenhuma Commentagem encontrada com o id="+id));
		commentRepository.deleteById(Comment.getId());
	}

}
