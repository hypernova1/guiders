package com.guiders.web.member.dao;

import com.guiders.web.member.domain.GuiderVO;

public interface MemberDAO {

  int checkEmail(String email);
  int joinMember(GuiderVO guiderVO);
  
}
