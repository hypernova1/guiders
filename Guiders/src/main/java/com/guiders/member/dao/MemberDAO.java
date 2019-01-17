package com.guiders.member.dao;

import java.util.List;

import com.guiders.member.domain.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> selectMemberList();
	public void insertMember(MemberVO memberVO);
	public MemberVO selectMember(String email);
	public void updateMember(MemberVO memberVO);
	
	public void insertAuth(String email);
	public List<String> getAuthList(String email);
	
}
