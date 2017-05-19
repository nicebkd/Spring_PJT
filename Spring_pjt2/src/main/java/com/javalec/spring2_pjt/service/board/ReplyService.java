package com.javalec.spring2_pjt.service.board;

import java.util.List;

import com.javalec.spring2_pjt.model.board.dao.ReplyDAO;
import com.javalec.spring2_pjt.model.board.dto.ReplyVo;

public interface ReplyService {
	public List<ReplyDAO> list(Integer bno);
	public void create(ReplyVo vo);
	public void updaet(ReplyVo vo);
	public void delete(Integer rno);
}
