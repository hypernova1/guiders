package org.brokers.guiders.web.member;

import lombok.*;
import org.brokers.guiders.web.auth.role.Role;
import org.brokers.guiders.web.auth.role.RoleName;
import org.brokers.guiders.web.common.DateAudit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

}
