package com.joaocaboclosf.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocaboclosf.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
