package com.guiders.web.member.service;

import java.util.List;
import java.util.Map;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.domain.MemberVO;

public interface MemberService {
	
	List<MemberVO> selectMemberList();
	void joinMember(MemberVO memberVO);
	void modifyMember(GuiderVO guiderVO);
	List<String> getAuthList(String email);
	MemberVO loginCheck(String email);
    GuiderVO selectByEmail(String email, String type);
    List<Map<String, Object>> getGuiderList(Integer page, String email);
    Integer isFollow(String guider, String follow);
    Integer follow(String guider, String follow);
    Integer unfollow(String guider, String follow);

}
