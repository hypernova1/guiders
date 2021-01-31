package org.brokers.guiders.web.auth;

import lombok.Getter;
import org.brokers.guiders.web.auth.role.Role;
import org.brokers.guiders.web.member.Member;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class MemberAccount extends User {

    private final Member member;

    public MemberAccount(Member member) {
        super(member.getEmail(), member.getPassword(), createAuthorities(member.getRoles()));
        this.member = member;
    }

    private static List<SimpleGrantedAuthority> createAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority((role.getName().name()))
                ).collect(Collectors.toList());
    }

}
