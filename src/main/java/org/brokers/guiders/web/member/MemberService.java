package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.essay.Essay;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final FollowerRepository followerRepository;
    private final GuiderRepository guiderRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void modifyMember(Guider guider) {
        if (!guider.getPassword().isEmpty()) {
            String password = passwordEncoder.encode(guider.getPassword());
            guider.setPassword(password);
        }
        guiderRepository.save(guider);
    }

    public Member selectByEmail(String email, String type) {
        if (type.equals("guider")) {
            return guiderRepository.findByEmail(email)
                    .orElseThrow(MemberNotFoundException::new);
        }
        return followerRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
    }


    public List<Guider> getGuiderList(Integer page, Member email) {
        if (page == null) page = 0;
        PageRequest pageRequest = PageRequest.of(page, 16);
        Page<Guider> guiderPage = guiderRepository.findAll(pageRequest);

        return guiderPage.getContent();
    }

    public List<Essay> getMyLikeEssay(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        return member.getLikeEssay();
    }

    public List<Guider> getFollowerList(String email) {
        Follower follower = followerRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);

        return follower.getFollowList();
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
