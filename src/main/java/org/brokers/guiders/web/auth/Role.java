package org.brokers.guiders.web.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.common.DateAudit;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@NoArgsConstructor
public class Role extends DateAudit {

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    @Builder
    public Role(RoleName name) {
        this.name = name;
    }
}
