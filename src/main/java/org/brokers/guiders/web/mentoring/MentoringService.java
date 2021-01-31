package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.exception.MentoringNotFoundException;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.guider.GuiderRepository;
import org.brokers.guiders.web.member.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final GuiderRepository guiderRepository;

    public void question(MentoringDto request, Member member) {
        Guider guider = guiderRepository.findByEmail(request.getGuiderEmail())
                .orElseThrow(MemberNotFoundException::new);
        Mentoring mentoring = Mentoring.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .field(request.getField())
                .lang(request.getLang())
                .follower((Follower) member)
                .guider(guider)
                .build();
        mentoringRepository.save(mentoring);
    }

    public void answer(Mentoring mentoring) {
        mentoringRepository.save(mentoring);
    }

    public Mentoring getMentoring(Long id) {
        return mentoringRepository.findById(id).orElseThrow(MentoringNotFoundException::new);
    }

    public List<Mentoring> getMyQuestions(String email) {
        Guider guider = guiderRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        return guider.getMentoringList();
    }

    public List<Mentoring> getMentoringList(String guiderEmail, Member member) {
        Guider guider = guiderRepository.findByEmail(guiderEmail)
                .orElseThrow(MemberNotFoundException::new);
        Follower follower = (Follower) member;

        return mentoringRepository.findByGuiderAndFollower(guider, follower);
    }

}
