package com.javalec.spring2_pjt.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.javalec.spring2_pjt.model.board.dao.ReplyDAO;
import com.javalec.spring2_pjt.model.board.dto.ReplyVo;

@Repository
public class ReplyServiceImpl implements ReplyService{

	@Inject
	ReplyDAO replyDao;
	
	@Override
	public List<ReplyDAO> list(Integer bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(ReplyVo vo) {
		replyDao.create(vo);		
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
