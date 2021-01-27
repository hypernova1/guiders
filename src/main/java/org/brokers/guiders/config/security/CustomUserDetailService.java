package org.brokers.guiders.config.security;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.auth.AuthService;
import org.brokers.guiders.web.member.Member;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = authService.getMember(username);

        if (member == null) {
            throw new UsernameNotFoundException("다음의 사용자는 없습니다 : " + username);
        }

        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();

        List<String> list = authService.getAuthList(username); //로그인한 사용자의 권한 리스트 가져오기

        for (String s : list) {
            roles.add(new SimpleGrantedAuthority(s));
        }

        return new UserCustom(member.getEmail(), member.getName(), member.getPassword(), roles);
    }

}
