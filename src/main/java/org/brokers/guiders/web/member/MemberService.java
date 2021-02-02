package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.guider.GuiderDto;
import org.brokers.guiders.web.member.guider.GuiderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final GuiderRepository guiderRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Transactional
    public void modifyMember(MemberDto.Update memberDto, Member member) {
        String password = memberDto.getPassword();
        if (!password.isEmpty()) {
            memberDto.setPassword(passwordEncoder.encode(password));
        }
        member.update(memberDto);
        memberRepository.save(member);
    }

    public MemberDto.Update getInfo(Member member) {
        return modelMapper.map(member, MemberDto.Update.class);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
    }

    public List<GuiderDto> getGuiderList(Integer page, Member email) {
        PageRequest pageRequest = PageRequest.of(page - 1, 16);
        Page<Guider> guiderPage = guiderRepository.findAll(pageRequest);

        return guiderPage.getContent()
                .stream().map(guider -> modelMapper.map(guider, GuiderDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void followGuider(String guiderEmail, Member member) {
        Guider guider = guiderRepository.findByEmail(guiderEmail)
                .orElseThrow(MemberNotFoundException::new);
        Follower follower = (Follower) member;

        follower.follow(guider);
    }

    @Transactional
    public void unfollowGuider(String guiderEmail, Member member) {
        Guider guider = guiderRepository.findByEmail(guiderEmail)
                .orElseThrow(MemberNotFoundException::new);
        Follower follower = (Follower) member;

        follower.unfollow(guider);
    }

    public MemberDto.InfoResponse findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new);

        return modelMapper.map(member, MemberDto.InfoResponse.class);
    }
}
