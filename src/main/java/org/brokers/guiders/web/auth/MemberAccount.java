package org.brokers.guiders.web.auth;

import org.brokers.guiders.web.member.Member;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.stream.Collectors;

public class MemberAccount extends User {

    private final Member member;

    public MemberAccount(Member member) {
        super(member.getEmail(), member.getPassword(), member.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority((role.getName().name()))
                ).collect(Collectors.toList()));
        this.member = member;
    }

}
