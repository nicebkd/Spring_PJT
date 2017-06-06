package com.javalec.spring2_pjt.service.message;

import com.javalec.spring2_pjt.model.message.dto.MessageVo;

public interface MessageService {
	
	public void addMessage(MessageVo vo);
	public MessageVo readMessage(String userid,int mid);
	
}
