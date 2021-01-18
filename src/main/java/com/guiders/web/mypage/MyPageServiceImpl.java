package com.guiders.web.mypage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiders.web.essay.EssayVO;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {

    private final SqlSession sqlSession;

    @Override
    public List<EssayVO> getMyLikeEssay(String email) {
        return sqlSession.getMapper(MyPageDAO.class).selectMyLikeEssay(email);
    }

    @Override
    public String getEssayContent(Integer eno) {
        return sqlSession.getMapper(MyPageDAO.class).selectEssayContent(eno);
    }

    @Override
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
