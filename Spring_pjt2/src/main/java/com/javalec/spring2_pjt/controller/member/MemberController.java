package com.javalec.spring2_pjt.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.spring2_pjt.model.member.dto.MemberVO;
import com.javalec.spring2_pjt.service.member.MemberService;

//현재 클래스를 스프링에서 관리하는 컨트롤 bean
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Inject
	MemberService memberService;
	//로깅
	private static final Logger logger
				=LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping("login.do")
	public String login(){
		
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberVO vo
			,HttpSession session){
		boolean result = memberService.loginCheck(vo,session);
		ModelAndView mav = new ModelAndView();
		if(result==true){
			mav.setViewName("home");
			mav.addObject("message","success");
		}else{//로그인 실패
			
			mav.setViewName("member/login");
			mav.addObject("message","error");
		}
		
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("message","로그 아웃이 되었습니다.");
		memberService.logout(session);
		return mav;
	}

}
