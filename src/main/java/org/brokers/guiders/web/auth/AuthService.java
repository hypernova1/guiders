package org.brokers.guiders.web.auth;

import org.brokers.guiders.config.security.UserCustom;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberDAO;
import org.brokers.guiders.web.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

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
