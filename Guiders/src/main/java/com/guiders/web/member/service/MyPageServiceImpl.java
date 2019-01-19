package com.guiders.web.member.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.guiders.web.member.dao.MyPageDAO;
import com.guiders.web.member.domain.GuiderVO;

public class MyPageServiceImpl implements MyPageService {

  @Autowired
  private SqlSession sqlSession;
  
  @Override
  public List<GuiderVO> getMyGuiderList(String email) {
    return sqlSession.getMapper(MyPageDAO.class).getMyGuider(email);
  }

}
