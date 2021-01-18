package com.guiders.web.mypage;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.EssayVO;

public interface MyPageService {


    List<EssayVO> getMyLikeEssay(String email);

    String getEssayContent(Integer eno);

    List<Map<String, Object>> getMyGuiderList(String email);

}
