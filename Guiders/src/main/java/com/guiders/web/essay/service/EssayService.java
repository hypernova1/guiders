package com.guiders.web.essay.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.guiders.web.essay.domain.EssayVO;
import com.guiders.web.util.PageCriteria;

public interface EssayService {
	
	public void writeEssay(EssayVO essayVO);
	public EssayVO readEssay(int eno);
	public List<EssayVO> getEssayList(@Param("startNum") Integer startNum, 
			 						  @Param("cri") PageCriteria cri);
	public void modifyEssay(EssayVO essayVO);
	public void removeEssay(Integer eno);
	public int addRecommend(Map<String, String> map);
	public boolean confirmLike(Map<String, String> map);
	public Integer getEssayCount(PageCriteria cri);

}
