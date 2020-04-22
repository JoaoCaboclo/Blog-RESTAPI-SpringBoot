package com.joaocaboclosf.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocaboclosf.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
