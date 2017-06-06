package com.javalec.spring2_pjt.model.message.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.spring2_pjt.model.message.dto.MessageVo;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void create(MessageVo vo) {
		sqlSession.insert("message.create",vo);
	}

	@Override
	public MessageVo readMessage(int mid) {
		return null;
	}

	@Override
	public void updateState(int mid) {
		
	}
	

}
