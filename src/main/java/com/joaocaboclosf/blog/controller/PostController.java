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

import com.joaocaboclosf.blog.model.Post;
import com.joaocaboclosf.blog.repository.PostRepository;
import com.joaocaboclosf.blog.util.ResourceNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/posts")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Post createPost(@RequestBody Post post) {
		
		return postRepository.save(post);
	}
	
	//   Como chamar no browse - http://localhost:8085/posts
	@GetMapping("")
	public List<Post> listPosts() {
//		List<Post> lstPost = new ArrayList<Post>(); 
//		lstPost = postRepository.findAll();
		return postRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Post getPost(@PathVariable("id") Integer id) {
		
		return postRepository.findById(id).orElseThrow( ()->
		new ResourceNotFoundException("Nenhuma postagem encontrada com o id="+id));
	}

	@PutMapping("/{id}")
	public Post updatePost(@PathVariable("id") Integer id, @RequestBody Post post) {
		
		postRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Nenhuma postagem encontrada com o id="+id));
		return postRepository.save(post);
	}

	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") Integer id) {
		
		Post post = postRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Nenhuma postagem encontrada com o id="+id));
		postRepository.deleteById(post.getId());
	}
	
}
