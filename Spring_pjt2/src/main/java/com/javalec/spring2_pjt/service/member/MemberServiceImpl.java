package com.javalec.spring2_pjt.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.javalec.spring2_pjt.model.member.dao.MemberDAO;
import com.javalec.spring2_pjt.model.member.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDAO memberDao;
	
	@Override
	public boolean loginCheck(MemberVO vo,HttpSession session) {
		boolean result=memberDao.loginCheck(vo);
		if(result==true){//true일 경우 세션 등록
		MemberVO vo2 = viewMember(vo);
//		session.setAttribute("user",vo);
		session.setAttribute("userid",vo2.getUserid());
		session.setAttribute("username",vo2.getUsername());
		
		}

		return result;
	}

	@Override
	public void logout(HttpSession session) {
		
		//세션 개별 삭제
		//session.removeAttribute("userid");
		//세션 정보를 초기화 시킴
		session.invalidate();
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		
		return memberDao.viewMember(vo);
	}

}
