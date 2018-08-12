package com.rme.post.dto;

import java.util.List;
import java.util.Set;

import com.rme.post.model.Attachment;

public class PostDto 
{
	private String category;
	private String subject;
	private String description;
	private Set<Attachment> attachments;
	
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
	public Set<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	@Override
	public String toString() {
		return "PostDto [category=" + category + ", subject=" + subject + ", description=" + description
				+ ", attachments=" + attachments + "]";
	}
	
}
