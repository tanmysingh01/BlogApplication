package com.project.blogapplication.service;

import java.util.List;

import com.project.blogapplication.payload.PostDto;

public interface PostService {

	PostDto createPost(PostDto pd);

	List<PostDto> getAllPost();

	PostDto findById(Long Id);

	PostDto updatePost(PostDto pd, Long id);
	
	void deletePost(Long Id);

}
