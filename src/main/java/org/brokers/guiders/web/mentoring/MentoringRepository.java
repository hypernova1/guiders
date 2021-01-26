package org.brokers.guiders.web.mentoring;

import org.brokers.guiders.web.member.Follower;
import org.brokers.guiders.web.member.Guider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentoringRepository extends JpaRepository<Mentoring, Long> {
    List<Mentoring> findByGuiderAndFollower(Guider guider, Follower follower);

}
