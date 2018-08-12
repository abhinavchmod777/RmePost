package com.rme.post.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rme.post.model.Comment;
import com.rme.post.model.Reply;

@Repository
public class ReplyDao 
{
	@Autowired
	SessionFactory sf;

	//-------------------------addCommentByPostId--------------------------------//
	public boolean addReply(int id,Reply r)
	{
		Criteria criteria = sf.getCurrentSession().createCriteria(Comment.class);
		criteria.add(Restrictions.eq("id", id));
		List<Comment> comments = criteria.list();
		if(comments.isEmpty())
			return false;
		else {
			Comment comment = comments.get(0); 
			r.setComment(comment);
			sf.getCurrentSession().save(r);
			comment.getReplies().add(r);
		return true;
		}
	}

}
