package com.javalec.spring2_pjt.service.message;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.spring2_pjt.model.message.dao.MessageDAO;
import com.javalec.spring2_pjt.model.message.dao.PointDAO;
import com.javalec.spring2_pjt.model.message.dto.MessageVo;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Inject
	MessageDAO messageDAO;
	
	@Inject 
	PointDAO pointDAO;

	@Override
	public void addMessage(MessageVo vo) {
		
		//로그 확인(공통업무)
		
		//핵심업무
		//메시지를 테이블에 저장
		messageDAO.create(vo);
		//메시지를 발송한 회원에게 10포인트 추가
		pointDAO.updatePoint(vo.getSender(),10);
	}

	@Override
	public MessageVo readMessage(String userid, int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
