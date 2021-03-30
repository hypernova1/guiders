package org.brokers.guiders.web.member;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.auth.role.Role;
import org.brokers.guiders.web.auth.role.RoleName;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.member.payload.MemberUpdateForm;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id", callSuper = false)
public class Member extends DateAudit {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(name = "email", unique = true, nullable = false)
    protected String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "name")
    protected String name;

    @Column(name = "birth")
    protected String birth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    protected Gender gender;

    @Column(name = "phone")
    protected String phone;

    @Column(name = "photo_url")
    protected String photoUrl;

    @ManyToMany(mappedBy = "likes", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private final Set<Essay> likeEssayList = new HashSet<>();

    @JoinTable(
            name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ManyToMany(fetch = FetchType.EAGER)
    protected final Set<Role> roles = new HashSet<>();

    public void update(MemberUpdateForm updateForm) {
        this.name = updateForm.getName();
        if (!updateForm.getPassword().isEmpty()) {
            this.password = updateForm.getPassword();
        }
        this.phone = updateForm.getPhone();
        this.photoUrl = updateForm.getPhotoUrl();
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public boolean isGuider() {
        return this.roles.stream()
                .anyMatch((role) -> role.getName().equals(RoleName.ROLE_GUIDER));
    }

}
