package com.guiders.web.guiders.dao;

import java.util.List;
import java.util.Map;

import com.guiders.web.guiders.domain.MentoringVO;

public interface MentoringDAO {
    Integer insertMentoring(MentoringVO mentoringVO);

    Integer updateMentoring(MentoringVO mentoringVO);

    MentoringVO selectMentoring(Integer mtrno);

    List<Map<String, Object>> selectMyQuestions(String email);

    List<Map<String, Object>> selectMentoringList(Map<String, String> param);
}
