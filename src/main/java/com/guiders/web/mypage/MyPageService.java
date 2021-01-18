package com.guiders.web.mypage;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.EssayVO;

public interface MyPageService {


    public List<EssayVO> getMyLikeEssay(String email);

    public String getEssayContent(Integer eno);

    List<Map<String, Object>> getMyGuiderList(String email);

}
