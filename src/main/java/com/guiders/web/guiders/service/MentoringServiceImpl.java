package com.guiders.web.guiders.service;

import com.guiders.web.guiders.dao.MentoringDAO;
import com.guiders.web.guiders.domain.MentoringVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MentoringServiceImpl implements MentoringService {

    private final SqlSession sqlSession;

    @Override
    public Integer question(MentoringVO mentoringVO) {
        return sqlSession.getMapper(MentoringDAO.class).insertMentoring(mentoringVO);
    }

    @Override
    public Integer answer(MentoringVO mentoringVO) {
        return sqlSession.getMapper(MentoringDAO.class).updateMentoring(mentoringVO);
    }


    @Override
    public MentoringVO getMentoring(Integer mtrno) {
        return sqlSession.getMapper(MentoringDAO.class).selectMentoring(mtrno);
    }

    @Override
    public List<Map<String, Object>> getMyQuestions(String email) {
        return sqlSession.getMapper(MentoringDAO.class).selectMyQuestions(email);
    }

    @Override
    public List<Map<String, Object>> getMentoringList(String guider, String follower) {
        Map<String, String> param = new HashMap<>();
        param.put("guider", guider);
        param.put("follower", follower);
        return sqlSession.getMapper(MentoringDAO.class).selectMentoringList(param);
    }

}
