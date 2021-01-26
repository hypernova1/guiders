package org.brokers.guiders.web.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByGuiderAndFollow(Guider guider, Follower follower);
}