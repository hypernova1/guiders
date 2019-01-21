package com.guiders.web.member.service;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.domain.EssayVO;

public interface MyPageService {

  List<Map<String, String>> getMyGuiderList(String email);
  public List<EssayVO> getMyLikeEssay(String email);
  public String getEssayContent(Integer eno);
  
}
