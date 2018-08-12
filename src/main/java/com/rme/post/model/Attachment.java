package com.rme.post.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attachment
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	//--------------------getters and setters-------------------------------//
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
