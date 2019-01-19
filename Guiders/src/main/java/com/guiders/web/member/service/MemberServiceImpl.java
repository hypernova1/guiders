package com.guiders.web.member.service;

import java.util.List;
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
  public MemberVO readMember(String email) {
    return sqlSession.getMapper(MemberDAO.class).selectMember(email);
  }

  @Override
  public void modifyMember(GuiderVO guiderVO) {

    String password = bCryptPasswordEncoder.encode(guiderVO.getPassword());
    guiderVO.setPassword(password);
    sqlSession.getMapper(MemberDAO.class).updateMember(guiderVO);
  }

  @Override
  public List<String> getAuthList(String email) {
    return sqlSession.getMapper(MemberDAO.class).getAuthList(email);
  }

  @Override
  public GuiderVO selectByName(String name) {
    return sqlSession.getMapper(MemberDAO.class).selectByName(name);
  }

  @Override
  public void joinMember(MemberVO memberVO) {
  }

  @Override
  public MemberVO loginCheck(String email) {
    return sqlSession.getMapper(MemberDAO.class).loginCheck(email);
  }

  @Override
  public List<GuiderVO> getMyGuider(String email) {
    return sqlSession.getMapper(MemberDAO.class).getMyGuider(email);
  }


}
