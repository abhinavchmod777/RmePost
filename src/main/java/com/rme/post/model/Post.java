package com.rme.post.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
//@JsonIgnoreProperties("postId")
@JsonPropertyOrder({"postId","category","subject","description","views","creationTime","lastUpdateTime"})
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
	private int views;
	
//	@Lob
//	@Column(columnDefinition="mediumLob",nullable=true)
//	private byte[] attachment;

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
//	public byte[] getAttachment() {
//		return attachment;
//	}
//	public void setAttachment(byte[] attachment) {
//		this.attachment = attachment;
//	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}

	
	//----------------------------toString()----------------------------------------//
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", category=" + category + ", subject=" + subject + ", description="
				+ description + "]";
	}
	
}
