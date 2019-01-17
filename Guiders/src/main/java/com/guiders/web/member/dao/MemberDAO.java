package com.guiders.web.member.dao;

import java.util.List;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.domain.MemberVO;

public interface MemberDAO {

  int selectEmail(String email);
  int insertMember(GuiderVO guiderVO);
  int updateMember(GuiderVO guiderVO);
  int deleteMember(String email);
  MemberVO selectMember(String email);
  GuiderVO selectGuider(String email);
  List<GuiderVO> selectGuiderList();
  
}
