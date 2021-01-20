package org.brokers.guiders.web.essay;

import org.brokers.guiders.web.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {

    Optional<Recommend> findByMemberAndEssay(Member member, Essay essay);

}
