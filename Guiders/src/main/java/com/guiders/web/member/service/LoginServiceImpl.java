package com.guiders.web.member.service;

import java.util.HashMap;
import java.util.Map;
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
  
  /* JUnit 테스트 시에 injection 관련 에러가 나기 때문에 테스트 전에는 주석 처리 후 진행 */
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Override
  public void join(GuiderVO guiderVO) {
    guiderVO.setCtno(1);
    guiderVO.setPassword(bCryptPasswordEncoder.encode(guiderVO.getPassword()));
    
    String auth = null;
    
    Map<String, String> param = new HashMap<>();
    sqlSession.getMapper(MemberDAO.class).insertMember(guiderVO);
    
    if(guiderVO.getQuote() != null) {
      auth = "ROLE_GUIDER";
      sqlSession.getMapper(MemberDAO.class).insertGuider(guiderVO);
    } else {
      auth = "ROLE_MEMBER";
    }
    
    param.put("email", guiderVO.getEmail());
    param.put("auth", auth);
    
    sqlSession.getMapper(MemberDAO.class).insertAuth(param);
  }

}