package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final SqlSession sqlSession;

    public void question(Mentoring mentoring) {
        mentoringRepository.save(mentoring);
    }

    public void answer(Mentoring mentoring) {
        mentoringRepository.save(mentoring);
    }


    public Mentoring getMentoring(Long mtrno) {
        return mentoringRepository.findById(mtrno).orElseThrow(RuntimeException::new);
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
