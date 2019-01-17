package com.guiders.web.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guiders.web.member.dao.MemberDAO;
import com.guiders.web.member.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberVO> selectMemberList() {
		return sqlSession.getMapper(MemberDAO.class).selectMemberList();
	}

	@Transactional
	@Override
	public void joinMember(MemberVO memberVO) {
		sqlSession.getMapper(MemberDAO.class).insertMember(memberVO);
		sqlSession.getMapper(MemberDAO.class).insertAuth(memberVO.getEmail());
	}

	@Override
	public MemberVO readMember(String email) {
		return sqlSession.getMapper(MemberDAO.class).selectMember(email);
	}

	@Override
	public void modifyMember(MemberVO memberVO) {
		sqlSession.getMapper(MemberDAO.class).updateMember(memberVO);
	}

	@Override
	public List<String> getAuthList(String email) {
		return sqlSession.getMapper(MemberDAO.class).getAuthList(email);
	}
	
}
