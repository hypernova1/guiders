package org.brokers.guiders.web.auth;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.member.Follower;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Transactional
    public Long join(JoinDto joinDto) {
        joinDto.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        Member member;
        Role role;
        if (joinDto.getType().equals("guider")) {
            role = roleRepository.findByName(RoleName.ROLE_GUIDER)
                    .orElseGet(() -> Role.builder().name(RoleName.ROLE_GUIDER).build());
            member = modelMapper.map(joinDto, Guider.class);
        } else {
            member = modelMapper.map(joinDto, Follower.class);
            role = roleRepository.findByName(RoleName.ROLE_MEMBER)
                    .orElseGet(() -> Role.builder().name(RoleName.ROLE_MEMBER).build());
        }
        member.addRole(role);
        Member savedMember = memberRepository.saveAndFlush(member);
        return savedMember.getId();
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
    }

    public void login(LoginDto loginDto) {
        Member member = memberRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(MemberNotFoundException::new);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                new MemberAccount(member),
                loginDto.getPassword(),
                member.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority((role.getName().name()))
                        ).collect(Collectors.toList())
        );
        SecurityContextHolder.getContext().setAuthentication(token);
    }
}
