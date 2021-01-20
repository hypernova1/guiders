package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final FollowerRepository followerRepository;
    private final GuiderRepository guiderRepository;
    private final SqlSession sqlSession;

    private final PasswordEncoder passwordEncoder;

    public void modifyMember(Guider guider) {
        if (!guider.getPassword().isEmpty()) {
            String password = passwordEncoder.encode(guider.getPassword());
            guider.setPassword(password);
        }
        guiderRepository.save(guider);
    }

    public List<String> getAuthList(String email) {
        //TODO: 권한 리스트
        return Collections.emptyList();
    }

    public Member loginCheck(String email) {
        return sqlSession.getMapper(MemberDAO.class).loginCheck(email);
    }

    public Guider selectByEmail(String email, String type) {
        Map<String, String> param = new HashMap<>();
        param.put("email", email);
        param.put("type", type);
        return sqlSession.getMapper(MemberDAO.class).selectByEmail(param);
    }


    public List<Map<String, Object>> getGuiderList(Integer page, String email) {
        if (page == null) page = 0;

        Map<String, Object> param = new HashMap<>();
        param.put("page", page);
        param.put("email", email);
        return sqlSession.getMapper(MemberDAO.class).selectGuiderList(param);
    }


    public Integer isFollow(String guider, String follow) {
        Map<String, String> param = new HashMap<>();
        param.put("follower", follow);
        param.put("guider", guider);
        return sqlSession.getMapper(MemberDAO.class).selectFollow(param);
    }


    public Integer follow(String guider, String follow) {
        Map<String, String> param = new HashMap<>();
        param.put("follower", follow);
        param.put("guider", guider);
        return sqlSession.getMapper(MemberDAO.class).insertFollow(param);
    }


    public Integer unfollow(String guider, String follow) {
        Map<String, String> param = new HashMap<>();
        param.put("follower", follow);
        param.put("guider", guider);
        return sqlSession.getMapper(MemberDAO.class).deleteFollow(param);
    }


}
