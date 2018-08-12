package com.rme.post.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rme.post.dao.ReplyDao;
import com.rme.post.dto.ReplyDto;
import com.rme.post.model.Reply;

@Service
public class ReplyService
{
	@Autowired
	ReplyDao dao;
	
	@Transactional
	public boolean addReply(ReplyDto dto, int id)
	{
		Reply reply = new Reply();
		reply.setDescription(dto.getDescription());
		return dao.addReply(id, reply);
	}
}
