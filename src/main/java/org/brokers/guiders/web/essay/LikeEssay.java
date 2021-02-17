package org.brokers.guiders.web.essay;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.member.Member;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "like_essay")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeEssay extends DateAudit {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "essay_id")
    private Essay essay;


    @Builder
    public LikeEssay(Essay essay, Member member) {
        this.essay = essay;
        this.member = member;
    }
}
