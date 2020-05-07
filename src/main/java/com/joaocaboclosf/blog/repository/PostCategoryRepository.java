package com.joaocaboclosf.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocaboclosf.blog.model.PostCategory;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer>{

}
