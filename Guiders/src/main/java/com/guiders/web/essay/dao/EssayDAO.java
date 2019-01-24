package com.guiders.web.essay.dao;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.domain.EssayVO;

public interface EssayDAO {

	public void insertEssay(EssayVO essayVO);
	public EssayVO selectEssay(Integer eno);
	public List<EssayVO> selectEssayList(Integer startNum);
	public void updateEssay(EssayVO essayVO);
	public void deleteEssay(Integer eno);
	public Integer selectLikeCnt(Map<String, String> map);
	public void insertRecommend(Map<String, String> map);
	public void deleteRecommend(Map<String, String> map);
	public Integer getCount(String eno);
	public Integer selectEssayCount();
	
}
