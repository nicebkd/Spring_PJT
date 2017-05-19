package com.javalec.spring2_pjt.model.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.spring2_pjt.model.board.dto.ReplyVo;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	SqlSession sqlSession;
	 
	
	@Override
	public List<ReplyDAO> list(Integer bno) {
		
		
		return null;
	}

	@Override
	public void create(ReplyVo vo) {
		
		sqlSession.insert("reply.insertReply",vo);
	}

	@Override
	public void updaet(ReplyVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
		
	}




}
