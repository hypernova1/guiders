package com.guiders.web.member.dao;

import java.util.List;

public interface MyPageDAO {

  List<String> selectGuiderNameList(String follower);
}
