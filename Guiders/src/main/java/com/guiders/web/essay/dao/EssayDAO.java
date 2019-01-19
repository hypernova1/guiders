package com.guiders.web.essay.dao;

import java.util.Map;

import com.guiders.web.essay.domain.EssayVO;

public interface EssayDAO {

	public void insertEssay(EssayVO essayVO);
	
	public Map<String, String> selectEssay(int eno);
	
}
