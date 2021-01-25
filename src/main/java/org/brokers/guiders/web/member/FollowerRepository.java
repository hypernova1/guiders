package org.brokers.guiders.web.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, Long> {

    Optional<Follower> findByEmail(String email);
}
