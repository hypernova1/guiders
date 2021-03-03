package org.brokers.guiders.web.auth;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.auth.role.Role;
import org.brokers.guiders.web.auth.role.RoleName;
import org.brokers.guiders.web.auth.role.RoleRepository;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberRepository;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long joinGuider(AuthDto.GuiderJoinRequest joinDto) {
        joinDto.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        Role role = roleRepository.findByName(RoleName.ROLE_GUIDER)
                .orElseGet(() -> Role.builder().name(RoleName.ROLE_GUIDER).build());
        Member member = Guider.create(joinDto);
        member.addRole(role);
        roleRepository.save(role);
        return memberRepository.save(member).getId();
    }

    @Transactional
    public Long joinFollower(AuthDto.FollowerJoinRequest joinDto) {
        Member member = Follower.create(joinDto);
        Role role = roleRepository.findByName(RoleName.ROLE_MEMBER)
                .orElseGet(() -> Role.builder().name(RoleName.ROLE_MEMBER).build());

        roleRepository.save(role);
        member.addRole(role);
        return memberRepository.save(member).getId();
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
    }

    public void login(AuthDto.LoginRequest loginDto) {
        Member member = getMember(loginDto.getEmail());
        if (!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
            throw new MemberNotFoundException();
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
