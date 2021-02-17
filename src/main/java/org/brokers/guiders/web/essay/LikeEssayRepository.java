package org.brokers.guiders.web.essay;

import org.brokers.guiders.web.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeEssayRepository extends JpaRepository<LikeEssay, Long> {

    LikeEssay findByMemberAndEssay(Member member, Essay essay);

    List<LikeEssay> findByMember(Member member);

    boolean existsByMemberAndEssay(Member member, Essay essay);
}
