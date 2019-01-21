package com.guiders.web.member.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiders.web.essay.domain.EssayVO;
import com.guiders.web.member.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Map<String, String>> getMyGuiderList(String email) {
		return sqlSession.getMapper(MyPageDAO.class).getMyGuiders(email);
	}

	@Override
	public List<EssayVO> getMyLikeEssay(String email) {
		return sqlSession.getMapper(MyPageDAO.class).selectMyLikeEssay(email);
	}

	@Override
	public String getEssayContent(Integer eno) {
		return sqlSession.getMapper(MyPageDAO.class).selectEssayContent(eno);
	}

}
