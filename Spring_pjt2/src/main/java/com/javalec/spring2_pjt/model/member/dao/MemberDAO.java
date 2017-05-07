package com.javalec.spring2_pjt.model.member.dao;

import com.javalec.spring2_pjt.model.member.dto.MemberVO;

public interface MemberDAO {
	
	public boolean loginCheck(MemberVO vo);
	public MemberVO viewMember(MemberVO vo);

}
