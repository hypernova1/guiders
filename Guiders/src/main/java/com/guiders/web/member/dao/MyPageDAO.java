package com.guiders.web.member.dao;

import java.util.List;
import java.util.Map;

public interface MyPageDAO {

  List<Map<String, Object>> getMyGuiders(String follower);
  List<Map<String, Object>> getMyQuestions(String follower);
}
