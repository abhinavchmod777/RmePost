package com.rme.post.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rme.post.dao.CommentDao;
import com.rme.post.dto.CommentDto;
import com.rme.post.model.Comment;

@Service
public class CommentService 
{
	@Autowired 
	CommentDao dao;
	
	@Transactional
	public boolean addComment(int id , CommentDto dto)
	{
		Comment comment = new Comment();
		comment.setDescription(dto.getDescription());
		return dao.addComment(id, comment);
	}

}
