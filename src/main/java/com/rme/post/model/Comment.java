package com.rme.post.model;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties({"post"})
@JsonPropertyOrder({"commentId","description","replies","creationTime","lastUpdateTime"})
@Entity
public class Comment extends AbstractTimestampEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comment_id")
	private int commentId;
	
	private String description;
	
	//manyToOne mapping to be established with userAccount
	
	@ManyToOne
	@JoinColumn(name="POST_ID",nullable=false)
	private Post post;
	
	@OneToMany(mappedBy="comment",cascade=CascadeType.ALL,fetch= FetchType.EAGER)
	private Set<Reply> replies ;

//-----------------------------getters and setters-------------------------------------//
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	

	
}
