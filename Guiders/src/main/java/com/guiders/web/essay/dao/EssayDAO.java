package com.guiders.web.essay.dao;

import java.util.List;
import java.util.Map;
import com.guiders.web.essay.domain.EssayVO;
import com.guiders.web.util.PageCriteria;

public interface EssayDAO {


  void insertEssay(EssayVO essayVO);

  EssayVO selectEssay(Integer eno);

  List<EssayVO> selectEssayList(Integer startNum, PageCriteria cri);

  void updateEssay(EssayVO essayVO);

  void deleteEssay(Integer eno);

  Integer selectLikeCnt(Map<String, String> map);

  void insertRecommend(Map<String, String> map);

  void deleteRecommend(Map<String, String> map);

  Integer getCount(String eno);

  Integer selectEssayCount(PageCriteria cri);

  List<Map<String, Object>> selectTopEssay();
  
  void increaseLikeCnt(Integer eno);
  
  void decreaseLikeCnt(Integer eno);
}
