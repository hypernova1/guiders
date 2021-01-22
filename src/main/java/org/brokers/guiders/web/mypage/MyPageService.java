package org.brokers.guiders.web.mypage;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.brokers.guiders.web.essay.Essay;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final SqlSession sqlSession;

    public List<Essay> getMyLikeEssay(String email) {

        return sqlSession.getMapper(MyPageDAO.class).selectMyLikeEssay(email);
    }

    public String getEssayContent(Integer eno) {
        return sqlSession.getMapper(MyPageDAO.class).selectEssayContent(eno);
    }

    public List<Map<String, Object>> getMyGuiderList(String email) {
        List<Map<String, Object>> myGuiders = sqlSession.getMapper(MyPageDAO.class).getMyGuiders(email);
        List<Map<String, Object>> myQuestion = sqlSession.getMapper(MyPageDAO.class).getMyQuestions(email);

        for (Map<String, Object> myGuider : myGuiders) {
            List<Map<String, Object>> question = new ArrayList<>();
            for (Map<String, Object> stringObjectMap : myQuestion) {
                if (myGuider.get("email").toString().equals(stringObjectMap.get("guider").toString())) {
                    question.add(stringObjectMap);
                }
            }
            myGuider.put("question", question);
        }

        return myGuiders;
    }

}
