package org.brokers.guiders.web.member.follower;

import lombok.Getter;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "follower")
@Getter
@DiscriminatorValue("follower")
public class Follower extends Member {

    @OneToMany
    @JoinTable(
            name = "follow",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "guider_id")
    )
    private final List<Guider> followList = new ArrayList<>();

    @OneToMany
    private final List<Essay> likeEssay = new ArrayList<>();

    public void unfollow(Guider guider) {
        this.followList.remove(guider);
    }

    public void follow(Guider guider) {
        this.followList.add(guider);
    }

}
