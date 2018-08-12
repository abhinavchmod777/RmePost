package com.rme.post.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rme.post.model.Comment;
import com.rme.post.model.Post;

@Repository
public class CommentDao 
{
	@Autowired
	SessionFactory sf;

	//-------------------------addCommentByPostId--------------------------------//
	public boolean addComment(int id,Comment c)
	{
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.add(Restrictions.eq("id", id));
		List<Post> posts = criteria.list();
		if(posts.isEmpty())
			return false;
		else {
			Post post = posts.get(0);
			c.setPost(post);
			sf.getCurrentSession().save(c);
			post.getComments().add(c);
		return true;
		}
	}

}
