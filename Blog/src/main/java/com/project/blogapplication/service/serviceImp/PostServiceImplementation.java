package com.project.blogapplication.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blogapplication.entity.Post;
import com.project.blogapplication.exceptions.ResourceNotFoundException;
import com.project.blogapplication.payload.PostDto;
import com.project.blogapplication.repository.PostRepository;
import com.project.blogapplication.service.PostService;

@Service
public class PostServiceImplementation implements PostService {

	@Autowired
	private PostRepository repo;

	@Override
	public PostDto createPost(PostDto pd) {
		// Convert PostDTO to Post entity

		Post post = convertToEntity(pd);

		// saving Post to the repository/database
		Post newpost = repo.save(post);

		// convert Post to postdto

		PostDto npd = convertToDto(newpost);

		return npd;

	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		List<Post> posts = repo.findAll();

		List<PostDto> dtoposts = posts.stream().map(post -> convertToDto(post)).collect(Collectors.toList());

		return dtoposts;
	}

	// Convert DTO to Entity
	private Post convertToEntity(PostDto pd) {
		Post post = new Post();
		post.setTitle(pd.getTitle());
		post.setContent(pd.getContent());
		post.setDescription(pd.getDescription());
		return post;
	}

	// convert Post to postdto
	private PostDto convertToDto(Post newpost) {
		PostDto npd = new PostDto();
		npd.setContent(newpost.getContent());
		npd.setDescription(newpost.getDescription());
		npd.setId(newpost.getId());
		npd.setTitle(newpost.getTitle());

		return npd;
	}

	@Override
	public PostDto findById(Long Id) {

		Post p = repo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Post", "ID", String.valueOf(Id)));
		
		return convertToDto(p);
	}

	@Override
	public PostDto updatePost(PostDto pd, Long id) {
		
		
		Post p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "ID", String.valueOf(id)));
		
		
		
		
		p.setTitle(pd.getTitle());
		p.setContent(pd.getContent());
		p.setDescription(pd.getDescription());

		Post updatedPost = repo.save(p);
		PostDto pdnew = convertToDto(updatedPost);
		return pdnew;
	}

	@Override
	public void deletePost(Long Id) {
		// TODO Auto-generated method stub
		repo.deleteById(Id);
		
		
	}
	
	
	
	

}
