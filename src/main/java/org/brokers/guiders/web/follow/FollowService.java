package org.brokers.guiders.web.follow;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.member.Follower;
import org.brokers.guiders.web.member.FollowerRepository;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.GuiderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final GuiderRepository guiderRepository;
    private final FollowerRepository followerRepository;
    private final FollowRepository followRepository;

    public void follow(String guiderEmail, String followEmail) {
        Guider guider = guiderRepository.findByEmail(guiderEmail)
                .orElseThrow(RuntimeException::new);
        Follower follower = followerRepository.findByEmail(followEmail)
                .orElseThrow(RuntimeException::new);

        Follow follow = Follow.builder()
                .guider(guider)
                .follower(follower)
                .build();
        followRepository.save(follow);
    }

    public void unfollow(String guiderEmail, String followEmail) {
        Guider guider = guiderRepository.findByEmail(guiderEmail)
                .orElseThrow(RuntimeException::new);
        Follower follower = followerRepository.findByEmail(followEmail)
                .orElseThrow(RuntimeException::new);
        Follow follow = followRepository.findByGuiderAndFollower(guider, follower)
                .orElseThrow(RuntimeException::new);

        followRepository.delete(follow);
    }

}
