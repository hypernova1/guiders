package com.guiders.web.auth;

import com.guiders.web.member.Guider;
import com.guiders.web.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final SqlSession sqlSession;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(Guider guider) {
        guider.setPassword(bCryptPasswordEncoder.encode(guider.getPassword()));

        sqlSession.getMapper(MemberDAO.class).insertMember(guider);

        if (guider.getQuote() != null) {
            sqlSession.getMapper(MemberDAO.class).insertGuider(guider);
        }

    }

}
