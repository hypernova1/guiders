package com.guiders.web.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.guiders.web.member.dao.MemberDAO;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private SqlSession sqlSession;

  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  @Override
  public List<MemberVO> selectMemberList() {
    return sqlSession.getMapper(MemberDAO.class).selectMemberList();
  }


  @Override
  public void modifyMember(GuiderVO guiderVO) {
    if(!guiderVO.getPassword().equals("")) {
      String password = bCryptPasswordEncoder.encode(guiderVO.getPassword());
      guiderVO.setPassword(password);
    }
    sqlSession.getMapper(MemberDAO.class).updateMember(guiderVO);
  }

  @Override
  public List<String> getAuthList(String email) {
    return sqlSession.getMapper(MemberDAO.class).getAuthList(email);
  }

  @Override
  public void joinMember(MemberVO memberVO) {
	  
  }

  @Override
  public MemberVO loginCheck(String email) {
    return sqlSession.getMapper(MemberDAO.class).loginCheck(email);
  }

  @Override
  public GuiderVO selectByEmail(String email, String type) {
    Map<String, String> param = new HashMap<>();
    param.put("email", email);
    param.put("type", type);
    return sqlSession.getMapper(MemberDAO.class).selectByEmail(param);
  }


  @Override
  public List<Map<String, Object>> getGuiderList(Integer page, String email) {
    if (page == null) page = 0;
    
    Map<String, Object> param = new HashMap<>();
    param.put("page", page);
    param.put("email", email);
    return sqlSession.getMapper(MemberDAO.class).selectGuiderList(param);
  }


  @Override
  public Integer isFollow(String guider, String follow) {
    Map<String, String> param = new HashMap<>();
    param.put("follower", follow);
    param.put("guider", guider);
    return sqlSession.getMapper(MemberDAO.class).selectFollow(param);
  }


  @Override
  public Integer follow(String guider, String follow) {
    Map<String, String> param = new HashMap<>();
    param.put("follower", follow);
    param.put("guider", guider);
    return sqlSession.getMapper(MemberDAO.class).insertFollow(param);
  }


  @Override
  public Integer unfollow(String guider, String follow) {
    Map<String, String> param = new HashMap<>();
    param.put("follower", follow);
    param.put("guider", guider);
    return sqlSession.getMapper(MemberDAO.class).deleteFollow(param);
  }


}
