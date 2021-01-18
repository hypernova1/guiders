package com.guiders.web.member;

import java.util.List;
import java.util.Map;

public interface MemberDAO {

    List<MemberVO> selectMemberList();

    void insertMember(GuiderVO guiderVO);

    MemberVO loginCheck(String email);

    void insertGuider(GuiderVO guiderVO);

    void updateMember(GuiderVO guiderVO);

    void insertAuth(Map<String, String> param);

    List<String> getAuthList(String email);

    GuiderVO selectGuider();

    GuiderVO selectByEmail(Map<String, String> param);

    List<Map<String, Object>> selectGuiderList(Map<String, Object> page);

    Integer selectFollow(Map<String, String> param);

    Integer insertFollow(Map<String, String> param);

    Integer deleteFollow(Map<String, String> param);

}
