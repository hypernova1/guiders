package org.brokers.guiders.web.auth.role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.common.DateAudit;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "role")
public class Role extends DateAudit {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    protected Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    @Builder
    public Role(RoleName name) {
        this.name = name;
    }
}
