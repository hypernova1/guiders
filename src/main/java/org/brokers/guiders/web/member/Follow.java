package org.brokers.guiders.web.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor
public class Follow {

    @Id @GeneratedValue
    private Long id;
    @OneToOne
    private Guider guider;
    @OneToOne
    private Follower follower;

    @Builder
    public Follow(Guider guider, Follower follower) {
        this.guider = guider;
        this.follower = follower;
    }

}
