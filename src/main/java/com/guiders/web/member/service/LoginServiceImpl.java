package com.guiders.web.member.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.guiders.web.member.dao.MemberDAO;
import com.guiders.web.member.domain.GuiderVO;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private SqlSession sqlSession;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public void join(GuiderVO guiderVO) {
    guiderVO.setPassword(bCryptPasswordEncoder.encode(guiderVO.getPassword()));

    sqlSession.getMapper(MemberDAO.class).insertMember(guiderVO);

    if (guiderVO.getQuote() != null) {
      sqlSession.getMapper(MemberDAO.class).insertGuider(guiderVO);
    } else {
    }

  }

}
