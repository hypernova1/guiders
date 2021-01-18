package com.guiders.web.mypage;

import com.guiders.web.essay.EssayVO;

import java.util.List;
import java.util.Map;

public interface MyPageDAO {

    List<EssayVO> selectMyLikeEssay(String email);

    String selectEssayContent(Integer eno);

    List<Map<String, Object>> getMyGuiders(String follower);

    List<Map<String, Object>> getMyQuestions(String follower);
}
