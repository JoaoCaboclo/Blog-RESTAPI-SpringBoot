package com.joaocaboclosf.blog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="POSTCATEGORY")

public class PostCategory {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome", nullable = false, length=45)
    private String nome;

	//@OneToMany
	//@JoinColumn(name="Post_Category_id")
	//private List<Post> posts;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public List<Post> getPosts() {
//		return posts;
//	}

//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}

  
}
