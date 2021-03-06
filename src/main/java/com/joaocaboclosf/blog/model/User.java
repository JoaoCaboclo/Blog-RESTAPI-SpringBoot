package com.joaocaboclosf.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id 
	private Integer id;
	
	@Column(name="name", nullable=false, length = 150)
	private String name;
	
	@Column(name="email", nullable=false, length = 150)
	private String email;
	
	@Column(name="password", nullable=false, length = 150)
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
