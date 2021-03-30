package org.brokers.guiders.web.auth;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.auth.payload.FollowerJoinForm;
import org.brokers.guiders.web.auth.payload.GuiderJoinForm;
import org.brokers.guiders.web.auth.payload.LoginForm;
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
    public Long joinGuider(GuiderJoinForm joinForm) {
        joinForm.setPassword(passwordEncoder.encode(joinForm.getPassword()));
        Role role = roleRepository.findByName(RoleName.ROLE_GUIDER)
                .orElseThrow(RuntimeException::new);
        Member member = Guider.create(joinForm);
        member.addRole(role);
        return memberRepository.save(member).getId();
    }

    @Transactional
    public Long joinFollower(FollowerJoinForm joinForm) {
        Member member = Follower.create(joinForm);
        Role role = roleRepository.findByName(RoleName.ROLE_MEMBER)
                .orElseGet(() -> Role.builder().name(RoleName.ROLE_MEMBER).build());
        member.addRole(role);
        return memberRepository.save(member).getId();
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
    }

    public void login(LoginForm loginForm) {
        Member member = getMember(loginForm.getEmail());
        if (!passwordEncoder.matches(loginForm.getPassword(), member.getPassword())) {
            throw new MemberNotFoundException();
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getEmail(),
                        loginForm.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
