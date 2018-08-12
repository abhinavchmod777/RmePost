package com.rme.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rme.post.dto.ReplyDto;
import com.rme.post.service.ReplyService;

@RestController
public class ReplyController 
{
	@Autowired 
	ReplyService service;
	
	//-------------------------adding new Reply------------------------------//
	@PostMapping(value="/addReply/{id}") 
	public ResponseEntity<Object> addReply(@ModelAttribute("dto") ReplyDto dto , @PathVariable int id)
	{
		try {
			service.addReply(dto,id);
			return ResponseEntity.ok().body("Reply added");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error adding new Reply");
		}
	}
}
