package com.joaocaboclosf.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocaboclosf.blog.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

}
