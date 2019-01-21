package com.guiders.web.member.dao;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.domain.EssayVO;

public interface MyPageDAO {

  List<Map<String, String>> getMyGuiders(String follower);
  public List<EssayVO> selectMyLikeEssay(String email);
  public String selectEssayContent(Integer eno);
  
}
