package com.guiders.web.member.service;

import java.util.List;
import com.guiders.web.member.domain.GuiderVO;

public interface MyPageService {

  List<GuiderVO> getMyGuiderList(String email);
}
