package com.rme.post.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rme.post.dao.PostDao;
import com.rme.post.dto.PostDto;
import com.rme.post.model.Post;

@Service
public class PostService 
{
	@Autowired
	PostDao dao;
	
	@Transactional
	public void saveNewPost(PostDto dto)
	{
		Post post = new Post();
		post.setCategory(dto.getCategory().trim());
		post.setDescription(dto.getDescription().trim());
		post.setSubject(dto.getSubject().trim());
		dao.saveNewPost(post);
	}
	
	@Transactional
	public List<Post> getAllPosts()
	{
		return dao.getAllPosts();
	}
	
	@Transactional
	public List<Post> getAllPosts(String category)
	{
		return dao.getAllPosts(category);
	}
	
	@Transactional
	public boolean increseViewById(int id)
	{
		return dao.increaseViewById(id);
	}
	
	@Transactional
	public List<Post> getTodayPosts()
	{
		return dao.getTodayPosts();
	}

	@Transactional
	public List<Post> getWithin7DaysPosts()
	{
		return dao.getWithin7DaysPosts();
	}
	@Transactional
	public List<Post> getTopPosts()
	{
		return dao.getTopPosts(5);
	}
	@Transactional
	public boolean deletePostById(int id)
	{
		return dao.deletePostById(id);
	}
}
