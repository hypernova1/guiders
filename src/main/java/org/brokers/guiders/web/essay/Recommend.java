package org.brokers.guiders.web.essay;

import lombok.*;
import org.brokers.guiders.web.member.Member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Recommend {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Essay essay;

    @Builder
    public Recommend(Member member, Essay essay) {
        this.member = member;
        this.essay = essay;
    }

}
