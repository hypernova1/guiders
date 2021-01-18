package com.guiders.web.mypage;

import java.util.List;
import java.util.Map;

import com.guiders.web.essay.Essay;

public interface MyPageService {


    List<Essay> getMyLikeEssay(String email);

    String getEssayContent(Integer eno);

    List<Map<String, Object>> getMyGuiderList(String email);

}
