package com.javalec.spring2_pjt.contoller.board;

import java.lang.reflect.Method;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.spring2_pjt.model.board.dto.ReplyVo;
import com.javalec.spring2_pjt.service.board.Pager;
import com.javalec.spring2_pjt.service.board.ReplyService;

import oracle.net.aso.s;


// http://localhost:8080/spring02/view.do?bno=1
//http://localhost:8080/spring02/view/1 <-이렇게 가능함 RestController

//REST : REpresentational State Transfer
//하나의 URI가 하나의 고유한 리소스를 대표하도록
//설계된 개념
// http://localhost:8080/spring02/reply/list?bno=1
//http://localhost:8080/spring02/reply/list/1
//http://localhost:8080/spring02/reply/list/2



//@RestController //스프링 4.0부터 지원
@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	private static final Logger logger
	=LoggerFactory.getLogger(ReplyController.class);
	
	
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute ReplyVo vo,
			HttpSession session){
		String userid =(String)session.getAttribute("userid");
		vo.setReplyer(userid);
		replyService.create(vo);
	}
	
	//ResponseEntity : 데이터 + http status code
	//@ResponseBody : 객체를 Json으로
	//@RequestBody : json을 객체로
	@RequestMapping(value="insert_rest.do",method=RequestMethod.POST)
	public ResponseEntity<String> insert_rest(
			@RequestBody ReplyVo vo,
			HttpSession session){
		ResponseEntity<String> entity = null;
		try{
			String userid=(String) session.getAttribute("userid");
//			String userid="kim";
			vo.setReplyer(userid);
			replyService.create(vo);
			entity = new ResponseEntity<String>(
					"success",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		 
		return entity;
	}

// /reply/list/1 => 1번 게시물의 댓글 목록 리턴
// /reply/list/2 => 2번 게시물의 댓글 목록 리턴
// /@@PathVariable : url에 입력될 변수값 지정

//
	@RequestMapping(value="/list/{bno}"
			,method=RequestMethod.GET)
	public ModelAndView reply_list(
			@PathVariable("bno")int bno,
			@RequestParam(defaultValue="1")int curPage,
			ModelAndView mav,
			HttpSession session){
		int count = replyService.count(bno);//댓글 갯수
		Pager pager = new Pager(count, curPage);
		
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		List<ReplyVo> list = replyService.list(bno,start,end,session);
		//뷰의 이름 지정
		mav.setViewName("board/reply_list");
		//뷰에 전달할 데이터 지정
		mav.addObject("list",list);
		mav.addObject("pager",pager);
		//reply_list.jsp 로 포워딩
		
		return mav;
		
	}
	
	
	@RequestMapping("list.do")
	public ModelAndView list(
			@RequestParam int bno,
			@RequestParam(defaultValue="1") int curPage,
			ModelAndView mav,
			HttpSession session){
		
		int count = replyService.count(bno);//댓글 갯수
		Pager pager = new Pager(count, curPage);
		
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		List<ReplyVo> list = replyService.list(bno,start,end,session);
		//뷰의 이름 지정
		mav.setViewName("board/reply_list");
		//뷰에 전달할 데이터 지정
		mav.addObject("list",list);
		mav.addObject("pager",pager);
		//reply_list.jsp 로 포워딩
		
		return mav;
		
	}

//@controller : return =>view (화면)
//@restcontroller : return => 데이터
//@responsebody : 리턴 데이터를 json으로 변환(생략가능)

	@RequestMapping("list_json.do")
	public @ResponseBody List<ReplyVo> list_json(
			@RequestParam(defaultValue="1")int curPage,
			@RequestParam int bno,
			HttpSession session){
		
		int count = 10; //댓글 갯수
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		List<ReplyVo> list = replyService.list(bno,start,end,session);
		return list;
	}

	
	
}
