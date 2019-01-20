package com.guiders.web.essay.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiders.web.essay.dao.EssayDAO;
import com.guiders.web.essay.domain.EssayVO;

@Service
public class EssayServiceImpl implements EssayService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeEssay(EssayVO essayVO) {
		sqlSession.getMapper(EssayDAO.class).insertEssay(essayVO);
		
	}

	@Override
	public EssayVO readEssay(int eno) {
		return sqlSession.getMapper(EssayDAO.class).selectEssay(eno);
	}

	@Override
	public List<EssayVO> essayList() {
		return sqlSession.getMapper(EssayDAO.class).selectEssayList();
	}

	@Override
	public void modifyEssay(EssayVO essayVO) {
		sqlSession.getMapper(EssayDAO.class).updateEssay(essayVO);
	}

	
}
