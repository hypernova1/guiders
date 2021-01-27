package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.member.Follower;
import org.brokers.guiders.web.member.FollowerRepository;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.GuiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final GuiderRepository guiderRepository;
    private final FollowerRepository followerRepository;

    public void question(Mentoring mentoring) {
        mentoringRepository.save(mentoring);
    }

    public void answer(Mentoring mentoring) {
        mentoringRepository.save(mentoring);
    }


    public Mentoring getMentoring(Long id) {
        return mentoringRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Mentoring> getMyQuestions(String email) {
        Guider guider = guiderRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        return guider.getMentoringList();
    }

    public List<Mentoring> getMentoringList(String guiderEmail, String followerEmail) {
        Guider guider = guiderRepository.findByEmail(guiderEmail)
                .orElseThrow(RuntimeException::new);
        Follower follower = followerRepository.findByEmail(followerEmail)
                .orElseThrow(RuntimeException::new);

        return mentoringRepository.findByGuiderAndFollower(guider, follower);
    }

}
