package com.javalec.spring2_pjt.model.board.dao;

import java.util.List;

import com.javalec.spring2_pjt.model.board.dto.ReplyVo;

public interface ReplyDAO {
	public List<ReplyDAO> list(Integer bno);
	public void create(ReplyVo vo);
	public void updaet(ReplyVo vo);
	public void delete(Integer rno);
	
}
