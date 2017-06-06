package com.javalec.spring2_pjt.model.message.dao;

import com.javalec.spring2_pjt.model.message.dto.MessageVo;

public interface MessageDAO {
	
	public void create(MessageVo vo);
	public MessageVo readMessage(int mid);
	public void updateState(int mid);
	

}
