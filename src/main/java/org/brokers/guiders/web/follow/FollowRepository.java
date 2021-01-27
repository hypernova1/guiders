package org.brokers.guiders.web.follow;

import org.brokers.guiders.web.member.Follower;
import org.brokers.guiders.web.member.Guider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByGuiderAndFollower(Guider guider, Follower follower);
}
