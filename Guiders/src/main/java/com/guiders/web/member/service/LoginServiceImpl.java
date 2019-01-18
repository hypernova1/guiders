package com.guiders.web.member.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guiders.web.member.dao.MemberDAO;
import com.guiders.web.member.domain.GuiderVO;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private SqlSession sqlSession;
  
  @Override
  public void join(GuiderVO guiderVO) {
    sqlSession.getMapper(MemberDAO.class).insertMember(guiderVO);
    sqlSession.getMapper(MemberDAO.class).insertAuth(guiderVO.getEmail());
  }

}
