package com.guiders.web.member.service;

import java.util.List;
import java.util.Map;
import com.guiders.web.guiders.domain.MentoringVO;

public interface MyPageService {

  List<Map<String, Object>> getMyGuiderList(String email);

}
