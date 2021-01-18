package com.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MentoringService {

    private final SqlSession sqlSession;

    public Integer question(Mentoring mentoring) {
        return sqlSession.getMapper(MentoringDAO.class).insertMentoring(mentoring);
    }

    public Integer answer(Mentoring mentoring) {
        return sqlSession.getMapper(MentoringDAO.class).updateMentoring(mentoring);
    }


    public Mentoring getMentoring(Integer mtrno) {
        return sqlSession.getMapper(MentoringDAO.class).selectMentoring(mtrno);
    }

    public List<Map<String, Object>> getMyQuestions(String email) {
        return sqlSession.getMapper(MentoringDAO.class).selectMyQuestions(email);
    }

    public List<Map<String, Object>> getMentoringList(String guider, String follower) {
        Map<String, String> param = new HashMap<>();
        param.put("guider", guider);
        param.put("follower", follower);
        return sqlSession.getMapper(MentoringDAO.class).selectMentoringList(param);
    }

}
