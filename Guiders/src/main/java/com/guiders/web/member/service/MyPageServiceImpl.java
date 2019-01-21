package com.guiders.web.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guiders.web.guiders.dao.MentoringDAO;
import com.guiders.web.guiders.domain.MentoringVO;
import com.guiders.web.member.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService {

  @Autowired
  private SqlSession sqlSession;
  
  @Override
  public List<Map<String, Object>> getMyGuiderList(String email) {
    List<Map<String, Object>> myGuiders = sqlSession.getMapper(MyPageDAO.class).getMyGuiders(email);
    List<Map<String, Object>> myQuestion = sqlSession.getMapper(MyPageDAO.class).getMyQuestions(email);
    
    for (int i = 0; i < myGuiders.size(); i++) {
      List<Map<String, Object>> question = new ArrayList<>();
      for (int j = 0; j < myQuestion.size(); j++) {
        if (myGuiders.get(i).get("email").toString().equals(myQuestion.get(j).get("guider").toString())) {
          question.add(myQuestion.get(j));
        }
      }
      myGuiders.get(i).put("question", question);
    }

    return myGuiders;
  }


}
