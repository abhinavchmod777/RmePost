package com.rme.post.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
//@JsonIgnoreProperties("postId")
@JsonPropertyOrder({"postId","category","subject","description","likes","dislikes","attachments","comments","creationTime","lastUpdateTime"})
public class Post extends AbstractTimestampEntity
{
//-----------------------primary fields--------------------------------//
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	private String category;
	private String subject;
	private String description;
	private int likes;
	private int dislikes;

// MantToOne mapping to be established with the userAccount

	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Attachment> attachments ;
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL , fetch=FetchType.EAGER)
	private Set<Comment> comments = new HashSet<Comment>();


//--------------------getters and setters------------------------------//
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int views) {
		this.likes = views;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public Set<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
}
