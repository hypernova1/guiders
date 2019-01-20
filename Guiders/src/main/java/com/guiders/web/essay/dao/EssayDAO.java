package com.guiders.web.essay.dao;

import java.util.List;

import com.guiders.web.essay.domain.EssayVO;

public interface EssayDAO {

	public void insertEssay(EssayVO essayVO);
	public EssayVO selectEssay(int eno);
	public List<EssayVO> selectEssayList();
	public void updateEssay(EssayVO essayVO);
	
}
