package com.rme.post.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rme.post.dto.PostDto;
import com.rme.post.model.Post;
import com.rme.post.service.PostService;
import com.rme.post.utils.ErrorsValidator;

@RestController
public class PostController 
{
	@Autowired
	PostService postService;
	
	
	//----------------------creating new post------------------------------//
	@PostMapping(value="/createPost")
	public ResponseEntity<Object> createPost(@ModelAttribute("dto") PostDto dto)
	{
		ArrayList<String> errors = ErrorsValidator.validatePost(dto);
		try {
			if(errors.isEmpty()) {
				postService.saveNewPost(dto);
				return ResponseEntity.ok().body(dto);
			}
			else
				return ResponseEntity.badRequest().body(errors);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error creating new post");
		}

	}
	
	//----------------------showing all posts-------------------------------//
	@GetMapping(value="/showPosts")
	public ResponseEntity<Object> showPosts()
	{
		try {
			List<Post> posts = postService.getAllPosts();
			return ResponseEntity.ok().body(posts);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error showing all post");
		}
	}
	
	//--------------------showing all posts via category----------------------//
	@GetMapping(value="/showPosts/{category}")
	public ResponseEntity<Object> showPosts(@PathVariable String category)
	{
		try {
			List<Post> posts = postService.getAllPosts(category);
			return ResponseEntity.ok().body(posts);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error showing all "+category+" post");
		}
	}
	
	//---------------------------increment likes by id---------------------------//
	@PostMapping(value="/likePost/{id}")
	public ResponseEntity<Object> increaseLikes(@PathVariable int id)
	{
		try {
			
			postService.increaseLikesById(id);
			return ResponseEntity.ok().body("likes incremented");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error incrementing likes ");
		}
	}
	
	//---------------------------increment dislikes by id---------------------------//
	@PostMapping(value="/dislikePost/{id}")
	public ResponseEntity<Object> increaseDislike(@PathVariable int id)
	{
		try {
			
			postService.increaseLikesById(id);
			return ResponseEntity.ok().body("Dislikes incremented");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error incrementing dislikes ");
		}
	}
	
	//----------------------------get today posts--------------------------------//
	@GetMapping(value="/todayPosts")
	public ResponseEntity<Object> getTodayPosts()
	{
		try {
			List<Post> posts = postService.getTodayPosts();
			return ResponseEntity.ok().body(posts);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error");
		}
		
	}

	//----------------------------get within 7 days posts--------------------------------//
	@GetMapping(value="/Within7DaysPosts")
	public ResponseEntity<Object> getWithin7DaysPosts()
	{
		try {
			List<Post> posts = postService.getWithin7DaysPosts();
			return ResponseEntity.ok().body(posts);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error");
		}
		
	}
	
	//------------------------------get top posts---------------------------------------//
	@GetMapping(value="/topPosts")
	public ResponseEntity<Object> getTopPosts()
	{
		try {
			List<Post> posts = postService.getTopPosts();
			return ResponseEntity.ok().body(posts);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error");
		}
		
	}
	
	//---------------------------------delete post----------------------------------------//
	@DeleteMapping(value="/deletePost/{id}")
	public ResponseEntity<Object> deletePostById(@PathVariable int id)
	{
		try {
			postService.deletePostById(id);
			return ResponseEntity.ok().body("post deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error deleting post");
		}
	}
	
	
}
