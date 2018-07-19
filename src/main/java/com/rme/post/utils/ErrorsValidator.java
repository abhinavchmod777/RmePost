package com.rme.post.utils;


import java.util.ArrayList;

import com.rme.post.dto.PostDto;

public class ErrorsValidator 
{
	
	public static ArrayList<String> validatePost(PostDto dto)
	{
		ArrayList<String> error = new ArrayList<String>();
		if(dto.getCategory().trim().isEmpty())
			error.add("Category cannot be empty");
		if(dto.getDescription().trim().isEmpty())
			error.add("Description cannot be empty");
		if(dto.getSubject().trim().isEmpty())
			error.add("Subject cannot be empty");
		return error;
	}
}
