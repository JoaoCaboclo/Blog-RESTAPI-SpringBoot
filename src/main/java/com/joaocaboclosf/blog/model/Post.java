package com.joaocaboclosf.blog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="POSTS")
public class Post {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title", nullable = false, length=150)
    private String title;
	
	@Lob
	@Column(name="content", nullable=false, columnDefinition="TEXT")
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updated_on;
	
	@OneToMany
	@JoinColumn(name="post_id")
	private List<Comment> comments;

	@OneToOne
	@JoinColumn(name="Post_Category_id")     
	private PostCategory postCategory; 
	
    public PostCategory getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(PostCategory postCategory) {
		this.postCategory = postCategory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
