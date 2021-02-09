package org.brokers.guiders.web.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.brokers.guiders.web.auth.role.Role;
import org.brokers.guiders.web.auth.role.RoleName;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.essay.Essay;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@DiscriminatorColumn(columnDefinition = "DTYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends DateAudit {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String email;

    protected String password;

    protected String name;

    @Enumerated(EnumType.STRING)
    protected Gender gender;

    protected String phone;

    protected String photoUrl;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "member_essay",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "essay_id")
    )
    protected final List<Essay> likeEssay = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    protected final Set<Role> roles = new HashSet<>();

    public void update(MemberDto.Update memberDto) {
        this.name = memberDto.getName();
        if (!memberDto.getPassword().isEmpty()) {
            this.password = memberDto.getPassword();
        }
        this.phone = memberDto.getPhone();
        this.photoUrl = memberDto.getPhotoUrl();
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public boolean isGuider() {
        return this.roles.stream()
                .anyMatch((role) -> role.getName().equals(RoleName.ROLE_GUIDER));
    }

    public boolean isMyLikeEssay(Long id) {
        return this.likeEssay.stream().map(Essay::getId)
                .anyMatch(essayId -> essayId.equals(id));
    };

    public void toggleLikeEssay(Essay essay) {
        if (this.likeEssay.contains(essay)) {
            essay.decrementLikeCount();
            likeEssay.remove(essay);
            return;
        }
        essay.incrementLikeCount();
        this.likeEssay.add(essay);
    }
}
