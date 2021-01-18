package com.guiders.security.config;

import com.guiders.web.member.Member;
import com.guiders.web.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberService.loginCheck(email);

        if (member == null) {
            throw new UsernameNotFoundException("다음의 사용자는 없습니다 : " + email);
        }

        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();

        List<String> list = memberService.getAuthList(email); //로그인한 사용자의 권한 리스트 가져오기

        for (String s : list) {
            roles.add(new SimpleGrantedAuthority(s));
        }

        return new UserCustom(member.getEmail(), member.getMname(), member.getPassword(), roles);
    }
}
