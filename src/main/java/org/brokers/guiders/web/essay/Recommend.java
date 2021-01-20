package org.brokers.guiders.web.essay;

import lombok.Builder;
import lombok.Getter;
import org.brokers.guiders.web.member.Member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Recommend {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private final Member member;
    @ManyToOne
    private final Essay essay;

    @Builder
    public Recommend(Member member, Essay essay) {
        this.member = member;
        this.essay = essay;
    }
}
