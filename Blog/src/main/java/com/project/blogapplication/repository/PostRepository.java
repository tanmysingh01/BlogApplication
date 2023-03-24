package com.project.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blogapplication.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
