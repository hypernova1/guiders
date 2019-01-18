package com.guiders.web.member.dao;

import java.util.List;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.domain.MemberVO;

public interface MemberDAO {

	public List<MemberVO> selectMemberList();

	public void insertMember(MemberVO memberVO);

	public MemberVO selectMember(String email);

	public void updateMember(GuiderVO guiderVO);

	public void insertAuth(String email);

	public List<String> getAuthList(String email);

	List<GuiderVO> selectGuiderList();
	
	public GuiderVO selectByName(String name);

}
