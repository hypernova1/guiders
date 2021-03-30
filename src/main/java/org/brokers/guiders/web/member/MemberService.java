package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.essay.EssayRepository;
import org.brokers.guiders.web.member.guider.payload.GuiderWithMentoringList;
import org.brokers.guiders.web.member.payload.MemberSummary;
import org.brokers.guiders.web.member.payload.MemberUpdateForm;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.guider.GuiderRepository;
import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.MentoringRepository;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;
import org.modelmapper.ModelMapper;
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
    private final EssayRepository essayRepository;
    private final MentoringRepository mentoringRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Transactional
    public void modifyMember(MemberUpdateForm updateForm, Member member) {
        String password = updateForm.getPassword();
        if (!password.isEmpty()) {
            updateForm.setPassword(passwordEncoder.encode(password));
        }
        member.update(updateForm);
        memberRepository.save(member);
    }

    public MemberUpdateForm getInfo(Member member) {
        return modelMapper.map(member, MemberUpdateForm.class);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
    }

    @Transactional
    public void followGuider(Long guiderId, Member member) {
        Guider guider = guiderRepository.findById(guiderId)
                .orElseThrow(MemberNotFoundException::new);
        Follower follower = (Follower) member;
        follower.follow(guider);
        memberRepository.save(member);
    }

    @Transactional
    public void unfollowGuider(Long guiderId, Member member) {
        Guider guider = guiderRepository.findById(guiderId)
                .orElseThrow(MemberNotFoundException::new);
        Follower follower = (Follower) member;
        follower.unfollow(guider);
        memberRepository.save(follower);
    }

    public MemberSummary findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new);

        return modelMapper.map(member, MemberSummary.class);
    }

    public List<GuiderWithMentoringList> getMyGuiderAndQuestion(Member member) {
        Follower follower = (Follower) member;
        List<Guider> guiderList = follower.getFollowList();
        List<GuiderWithMentoringList> guiderWithMentoringList = guiderList.stream()
                .map(guider -> modelMapper.map(guider, GuiderWithMentoringList.class))
                .collect(Collectors.toList());

        List<Mentoring> mentoringList = mentoringRepository.findByGuiderInAndFollower(guiderList, follower);

        for (Mentoring mentoring : mentoringList) {
            for (GuiderWithMentoringList guider : guiderWithMentoringList) {
                if (mentoring.getGuider().getEmail().equals(guider.getEmail())) {
                    MentoringDetail mentoringDetail = modelMapper.map(mentoring, MentoringDetail.class);
                    guider.addMentoring(mentoringDetail);
                }
            }
        }
        return guiderWithMentoringList;
    }

}
