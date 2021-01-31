package org.brokers.guiders.web.auth;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.auth.role.Role;
import org.brokers.guiders.web.auth.role.RoleName;
import org.brokers.guiders.web.auth.role.RoleRepository;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberRepository;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Transactional
    public Long join(AuthDto.JoinRequest joinDto) {
        joinDto.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        Member member;
        Role role;
        if (joinDto.getType().equals("guider")) {
            role = roleRepository.findByName(RoleName.ROLE_GUIDER)
                    .orElseGet(() -> Role.builder().name(RoleName.ROLE_GUIDER).build());
            roleRepository.save(role);
            member = modelMapper.map(joinDto, Guider.class);
        } else {
            member = modelMapper.map(joinDto, Follower.class);
            role = roleRepository.findByName(RoleName.ROLE_MEMBER)
                    .orElseGet(() -> Role.builder().name(RoleName.ROLE_MEMBER).build());
            roleRepository.save(role);
        }
        member.addRole(role);
        Member savedMember = memberRepository.saveAndFlush(member);
        return savedMember.getId();
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
    }

    public void login(AuthDto.LoginRequest loginDto) {
        Member member = memberRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(MemberNotFoundException::new);
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
