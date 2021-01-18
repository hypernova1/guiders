package org.brokers.guiders.web.mypage;

import org.brokers.guiders.web.essay.Essay;

import java.util.List;
import java.util.Map;

public interface MyPageDAO {

    List<Essay> selectMyLikeEssay(String email);

    String selectEssayContent(Integer eno);

    List<Map<String, Object>> getMyGuiders(String follower);

    List<Map<String, Object>> getMyQuestions(String follower);
}
