package com.guiders.web.guiders.service;

import java.util.List;
import java.util.Map;
import com.guiders.web.guiders.domain.MentoringVO;

public interface MentoringService {
  
  Integer question(MentoringVO mentoringVO);
  Integer answer(MentoringVO mentoringVO);
  MentoringVO getMentoring(Integer mtrno);
  List<Map<String, Object>> getMyQuestions(String email);
  List<Map<String, Object>> getMentoringList(String guider, String follower);
}
