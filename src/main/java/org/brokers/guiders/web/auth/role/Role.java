package org.brokers.guiders.web.auth.role;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.common.DateAudit;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "role")
public class Role extends DateAudit {

    @Id
    @GeneratedValue
    protected Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    @Builder
    public Role(RoleName name) {
        this.name = name;
    }
}
