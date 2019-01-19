package com.guiders.web.member.dao;

import java.util.List;
import com.guiders.web.member.domain.GuiderVO;

public interface MyPageDAO {

  List<String> selectGuiderNameList(String follower);
  List<GuiderVO> getMyGuider(String follower);
}
