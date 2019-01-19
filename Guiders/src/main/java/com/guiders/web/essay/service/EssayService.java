package com.guiders.web.essay.service;

import java.util.Map;

import com.guiders.web.essay.domain.EssayVO;

public interface EssayService {
	
	public void writeEssay(EssayVO essayVO);
	public Map<String, String> readEssay(int eno);

}
