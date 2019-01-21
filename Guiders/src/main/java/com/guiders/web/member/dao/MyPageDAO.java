package com.guiders.web.member.dao;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.domain.EssayVO;

public interface MyPageDAO {

  public List<EssayVO> selectMyLikeEssay(String email);
  public String selectEssayContent(Integer eno);
  List<Map<String, Object>> getMyGuiders(String follower);
  List<Map<String, Object>> getMyQuestions(String follower);
}
