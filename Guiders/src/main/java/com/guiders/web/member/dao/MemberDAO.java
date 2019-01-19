package com.guiders.web.member.dao;

import java.util.List;
import java.util.Map;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.domain.MemberVO;

public interface MemberDAO {

	public List<MemberVO> selectMemberList();

	public void insertMember(GuiderVO guiderVO);
	
	public MemberVO loginCheck(String email);
	
	public void insertGuider(GuiderVO guiderVO);

	public MemberVO selectMember(String email);

	public void updateMember(GuiderVO guiderVO);

	public void insertAuth(Map<String, String> param);

	public List<String> getAuthList(String email);

	public GuiderVO selectGuider();
	
	public GuiderVO selectByName(String name);
	
	public List<GuiderVO> getMyGuider(String email);
}
