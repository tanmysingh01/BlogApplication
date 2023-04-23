package com.project.blogapplication.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.blogapplication.exceptions.ResourceNotFoundException;
import com.project.blogapplication.payload.PostDto;
import com.project.blogapplication.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	private PostService postservice;

	public PostController(PostService postservice) {

		this.postservice = postservice;
	}

	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

		return new ResponseEntity<>(postservice.createPost(postDto), HttpStatus.CREATED);

	}

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPost(
		@RequestParam(value="pageNo", required = false, defaultValue = "0") int pageNo,
		@RequestParam(value="pageSize", required = false, defaultValue = "2") int pageSize
	) {

		return new ResponseEntity<List<PostDto>>(postservice.getAllPost(pageNo, pageSize), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getById(@PathVariable(name = "id") Long id) {
		PostDto p = postservice.findById(id);

		
		
		
		return ResponseEntity.ok(p);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto p, @PathVariable(name = "id") Long id) {
		
		
		
		PostDto pd = postservice.updatePost(p, id);

		return new ResponseEntity<PostDto>(pd, HttpStatus.OK);

	}
	
	
	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable(name="id") Long id) {
		postservice.deletePost(id);
		return "Post has been deleted with Id : " + id;
	}

}
