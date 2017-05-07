package com.javalec.spring2_pjt.service.member;

import javax.servlet.http.HttpSession;

import com.javalec.spring2_pjt.model.member.dto.MemberVO;

public interface MemberService {
	
	public boolean loginCheck(MemberVO vo,HttpSession session);
	public MemberVO viewMember(MemberVO vo);
	public void logout(HttpSession session);
	
	
	

}
