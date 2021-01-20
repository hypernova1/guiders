package org.brokers.guiders.web.member;

import lombok.Getter;
import org.brokers.guiders.web.mentoring.Mentoring;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorValue("guider")
public class Follower extends Member {

    @OneToMany
    private final List<Mentoring> mentoringList = new ArrayList<>();

}
