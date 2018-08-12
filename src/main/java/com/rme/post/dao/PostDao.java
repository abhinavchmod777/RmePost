package com.rme.post.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rme.post.model.Comment;
import com.rme.post.model.Post;

@Repository
public class PostDao 
{
	@Autowired
	SessionFactory sf;
	
	//------------------------saving new post-----------------------//
	public void saveNewPost(Post post)
	{
		sf.getCurrentSession().save(post);
	}
	
	//------------------------retrieving all posts-------------------//
	public List<Post> getAllPosts()
	{
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		List<Post> posts = criteria.list();
		return posts;
	}
	
	//---------------------retrieving posts via category--------------//
	public List<Post> getAllPosts(String category)
	{
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.add(Restrictions.eq("category", category));
		List<Post> posts = criteria.list();
		return posts;
	}
	
	//-----------------------increment likes----------------------------//
	public boolean increaseLikesById(int id)
	{
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.add(Restrictions.eq("id", id));
		List<Post> posts = criteria.list();
		if(posts.isEmpty())
			return false;
		else {
			Post post = posts.get(0);
			post.setLikes(post.getLikes()+1);
			return true;
		}
	}

	//-----------------------increment dislikes----------------------------//
	public boolean increaseDislikesById(int id)
	{
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.add(Restrictions.eq("id", id));
		List<Post> posts = criteria.list();
		if(posts.isEmpty())
			return false;
		else {
			Post post = posts.get(0);
			post.setDislikes(post.getDislikes()+1);
			return true;
		}
	}
	
	//---------------------get today posts-----------------------------//
	public List<Post> getTodayPosts()
	{
		List<Post> todayPosts = new ArrayList<Post>();
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		Date today = new Date();
		List<Post> posts = criteria.list();
		for(Post post:posts)
		{
			if(post.getCreationTime().getDate()==today.getDate() && post.getCreationTime().getMonth()==today.getMonth() && post.getCreationTime().getYear()==today.getYear())
			todayPosts.add(post);	
		}
		return todayPosts;
	}
	
	//---------------------get within 7 days posts-----------------------------//
	public List<Post> getWithin7DaysPosts()
	{
		List<Post> todayPosts = new ArrayList<Post>();
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		Date date = new Date();
		int x = date.getDate();
		if(x>=8)
		date.setDate(x-7);
		else {
			int y = date.getMonth();
			if(y==0)
				y=11;
			date.setMonth(y);
			date.setDate(24+x);
		}
		List<Post> posts = criteria.list();
		for(Post post:posts)
		{
			if(post.getCreationTime().compareTo(date)>0)
			todayPosts.add(post);	
		}
		return todayPosts;
	}
	
	//----------------------top posts-----------------------------------//
	public List<Post> getTopPosts(int i)
	{
		List<Post> Posts = sf.getCurrentSession().createQuery("FROM Post ORDER BY views DESC").list();
		List<Post> topPosts = new ArrayList<Post>();
		for(int x = 0 ; x < i ; x++)
			topPosts.add(Posts.get(x));
		return topPosts;
	}
	
	//---------------------deletePostById---------------------------------//
	public boolean deletePostById(int id)
	{
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.add(Restrictions.eq("id", id));
		List<Post> posts = criteria.list();
		if(posts.isEmpty())
			return false;
		else {
			Post post = posts.get(0);
			sf.getCurrentSession().delete(post);
			return true;
		}
	}
	
}
