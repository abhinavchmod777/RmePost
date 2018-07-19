package com.rme.post.dto;

public class PostDto 
{
	private String category;
	private String subject;
	private String description;
//	private byte[] attachment;
	
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
	@Override
	public String toString() {
		return "PostDto [category=" + category + ", subject=" + subject + ", description=" + description + "]";
	}

	
}
