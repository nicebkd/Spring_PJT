package com.javalec.spring2_pjt.contoller.board;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalec.spring2_pjt.model.board.dto.ReplyVo;
import com.javalec.spring2_pjt.service.board.ReplyService;


// http://localhost:8080/spring02/view.do?bno=1
//http://localhost:8080/spring02/view/1 <-이렇게 가능함 RestController

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute ReplyVo vo,
			HttpSession session){
		String userid =(String)session.getAttribute("userid");
		vo.setReplyer(userid);
		replyService.create(vo);
	}
	
	
}
