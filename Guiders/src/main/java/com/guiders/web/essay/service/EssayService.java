package com.guiders.web.essay.service;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.domain.EssayVO;

public interface EssayService {
	
	public void writeEssay(EssayVO essayVO);
	public EssayVO readEssay(int eno);
	public List<EssayVO> essayList();
	public void modifyEssay(EssayVO essayVO);
	public void removeEssay(Integer eno);
	public int addRecommend(Map<String, String> map);
	public boolean confirmLike(Map<String, String> map);

}
