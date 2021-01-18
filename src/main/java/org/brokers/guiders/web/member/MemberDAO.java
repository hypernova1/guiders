package org.brokers.guiders.web.member;

import java.util.List;
import java.util.Map;

public interface MemberDAO {

    List<Member> selectMemberList();

    void insertMember(Guider guider);

    Member loginCheck(String email);

    void insertGuider(Guider guider);

    void updateMember(Guider guider);

    void insertAuth(Map<String, String> param);

    List<String> getAuthList(String email);

    Guider selectGuider();

    Guider selectByEmail(Map<String, String> param);

    List<Map<String, Object>> selectGuiderList(Map<String, Object> page);

    Integer selectFollow(Map<String, String> param);

    Integer insertFollow(Map<String, String> param);

    Integer deleteFollow(Map<String, String> param);

}
