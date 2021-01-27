package org.brokers.guiders.web.member;

import lombok.Getter;
import org.brokers.guiders.web.essay.Essay;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorValue("follower")
public class Follower extends Member {

    @OneToMany
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
