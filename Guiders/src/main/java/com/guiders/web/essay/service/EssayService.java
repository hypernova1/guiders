package com.guiders.web.essay.service;

import java.util.List;

import com.guiders.web.essay.domain.EssayVO;

public interface EssayService {
	
	public void writeEssay(EssayVO essayVO);
	public EssayVO readEssay(int eno);
	public List<EssayVO> essayList();
	public void modifyEssay(EssayVO essayVO);

}
