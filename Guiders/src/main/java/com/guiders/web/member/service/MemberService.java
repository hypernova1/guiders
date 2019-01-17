package com.guiders.web.member.service;

import java.util.List;

import com.guiders.web.member.domain.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectMemberList();
	public void joinMember(MemberVO memberVO);
	public MemberVO readMember(String email);
	public void modifyMember(MemberVO memberVO);
	public List<String> getAuthList(String email);

}
