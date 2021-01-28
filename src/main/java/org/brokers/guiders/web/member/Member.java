package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.brokers.guiders.web.auth.Role;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.essay.Essay;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(columnDefinition = "DTYPE")
@ToString
public class Member extends DateAudit {

    @Column(unique = true, nullable = false)
    protected String email;

    protected String password;

    protected String name;

    @Enumerated(EnumType.STRING)
    protected Gender gender;

    protected String phone;

    protected String photo;

    @OneToMany
    protected final List<Essay> likeEssay = new ArrayList<>();

    @ManyToMany
    protected final Set<Role> roles = new HashSet<>();

    public void toggleLikeEssay(Essay essay) {
        if (likeEssay.contains(essay)) {
            essay.decrementLikeCount();
            likeEssay.remove(essay);
            return;
        }
        likeEssay.add(essay);
        essay.incrementLikeCount();
    }
}
