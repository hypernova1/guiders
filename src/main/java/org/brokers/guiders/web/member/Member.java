package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.brokers.guiders.web.auth.Role;
import org.brokers.guiders.web.auth.RoleName;
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

    protected String photoUrl;

    @OneToMany
    protected final List<Essay> likeEssay = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    protected final Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void toggleLikeEssay(Essay essay) {
        if (likeEssay.contains(essay)) {
            essay.decrementLikeCount();
            likeEssay.remove(essay);
            return;
        }
        likeEssay.add(essay);
        essay.incrementLikeCount();
    }

    public boolean isGuider() {
        return this.roles.stream()
                .anyMatch((role) -> role.getName().equals(RoleName.ROLE_GUIDER));
    }

    public boolean isMyLikeEssay(Long id) {
        return this.likeEssay.stream().map(DateAudit::getId)
                .anyMatch(essayId -> essayId.equals(id));
    };
}
