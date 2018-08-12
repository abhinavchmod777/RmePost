package com.rme.post.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties({"comment"})
@JsonPropertyOrder({"replyId","description","creationTime","lastUpdateTime"})
@Entity
public class Reply extends AbstractTimestampEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reply_id")
	private int replyId;
	private String description;
	
	//manyToOne mapping to be established with userAccount
	
	@ManyToOne
	@JoinColumn(name="COMMENT_ID",nullable=false)
	private Comment comment;

	//------------------------------------Getters and Setters--------------------------------//
	
	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}


}
