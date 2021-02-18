package org.brokers.guiders.web.member;

import lombok.*;
import org.brokers.guiders.web.auth.role.Role;
import org.brokers.guiders.web.auth.role.RoleName;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.essay.Essay;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "member")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@DiscriminatorColumn(columnDefinition = "DTYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id", callSuper = false)
public class Member extends DateAudit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String email;

    protected String password;

    protected String name;

    @Enumerated(EnumType.STRING)
    protected Gender gender;

    protected String phone;

    protected String photoUrl;

    @OneToMany
    @JoinTable(
            name = "like_essay",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "essay_id")
    )
    private final List<Essay> likeEssayList = new ArrayList<>();

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
        return this.likeEssayList.stream()
                .anyMatch(essay -> essay.getId().equals(id));
    }

    public void removeLikeEssay(Long id) {
        this.likeEssayList.removeIf(essay -> essay.getId().equals(id));
    }

    public void addLikeEssay(Essay essay) {
        this.likeEssayList.add(essay);
    }
}
