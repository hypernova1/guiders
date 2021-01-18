package com.guiders.web.auth;

import com.guiders.security.config.UserCustom;
import com.guiders.web.member.Guider;
import com.guiders.web.member.Member;
import com.guiders.web.member.MemberDAO;
import com.guiders.web.member.MemberService;
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
public class AuthService implements UserDetailsService {

    private final SqlSession sqlSession;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberService memberService;

    public void join(Guider guider) {
        guider.setPassword(bCryptPasswordEncoder.encode(guider.getPassword()));

        sqlSession.getMapper(MemberDAO.class).insertMember(guider);

        if (guider.getQuote() != null) {
            sqlSession.getMapper(MemberDAO.class).insertGuider(guider);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.loginCheck(username);

        if (member == null) {
            throw new UsernameNotFoundException("다음의 사용자는 없습니다 : " + username);
        }

        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();

        List<String> list = memberService.getAuthList(username); //로그인한 사용자의 권한 리스트 가져오기

        for (String s : list) {
            roles.add(new SimpleGrantedAuthority(s));
        }

        return new UserCustom(member.getEmail(), member.getMname(), member.getPassword(), roles);
    }
}
