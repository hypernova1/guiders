package org.brokers.guiders.web.member.follower;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.auth.AuthDto;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.guider.Guider;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "follower")
@DiscriminatorValue("follower")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follower extends Member {

    @OneToMany
    @JoinTable(
            name = "follower_follow_list",
            joinColumns = @JoinColumn(name = "follow_id"),
            inverseJoinColumns = @JoinColumn(name = "guider_id")
    )
    private final List<Guider> followList = new ArrayList<>();

    public static Follower create(AuthDto.JoinRequest request) {
        Follower follower = new Follower();
        follower.email = request.getEmail();
        follower.password = request.getPassword();
        follower.name = request.getName();
        follower.phone = request.getPhone();
        follower.photoUrl = request.getPhotoUrl();
        return follower;
    }

    public void unfollow(Guider guider) {
        this.followList.remove(guider);
    }

    public void follow(Guider guider) {
        this.followList.add(guider);
    }

}
