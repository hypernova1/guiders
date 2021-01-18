package org.brokers.guiders.web.mentoring;

import java.util.List;
import java.util.Map;

public interface MentoringDAO {
    Integer insertMentoring(Mentoring mentoring);

    Integer updateMentoring(Mentoring mentoring);

    Mentoring selectMentoring(Integer mtrno);

    List<Map<String, Object>> selectMyQuestions(String email);

    List<Map<String, Object>> selectMentoringList(Map<String, String> param);
}
