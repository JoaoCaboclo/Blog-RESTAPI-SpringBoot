package com.joaocaboclosf.blog.controller;

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
import com.joaocaboclosf.blog.model.PostCategory;
import com.joaocaboclosf.blog.repository.PostCategoryRepository;
import com.joaocaboclosf.blog.util.ResourceNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/postcategory")

public class PostCategoryController {

	@Autowired

	PostCategoryRepository postCategoryRepository;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public PostCategory createPostCategory(@RequestBody PostCategory postCategory) {
		
		return postCategoryRepository.save(postCategory);
	}
	
	//   Como chamar no browse - http://localhost:8085/Comments
	@GetMapping("")
	public List<PostCategory> listPostCategory() {
		return postCategoryRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public PostCategory getPostCategory(@PathVariable("id") Integer id) {
		
		return postCategoryRepository.findById(id).orElseThrow( ()->
		new ResourceNotFoundException("Nenhuma Categoria encontrada com o id="+id));
	}

	@PutMapping("/{id}")
	public PostCategory updatePostCategory(@PathVariable("id") Integer id, @RequestBody PostCategory postCategory) {
		
		postCategoryRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Nenhuma Categoria encontrada com o id="+id));
		return postCategoryRepository.save(postCategory);
	}

	@DeleteMapping("/{id}")
	public void deletePostCategory(@PathVariable("id") Integer id) {
		
		PostCategory postCategory = postCategoryRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Nenhuma Commentagem encontrada com o id="+id));
		postCategoryRepository.deleteById(postCategory.getId());
	}

}
