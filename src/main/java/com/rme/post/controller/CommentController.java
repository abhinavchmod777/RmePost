package com.rme.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rme.post.dto.CommentDto;
import com.rme.post.service.CommentService;

@RestController
public class CommentController 
{
	@Autowired
	CommentService service;
	
	//-------------------------adding new comment------------------------------//
	@PostMapping(value="/addComment/{id}") 
	public ResponseEntity<Object> addComment(@ModelAttribute("dto") CommentDto dto , @PathVariable int id)
	{
		try {
			service.addComment(id, dto);
			return ResponseEntity.ok().body("comment added");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error adding new comment");
		}
	}
}
