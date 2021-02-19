package org.brokers.guiders.web.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.brokers.guiders.web.essay.EssayDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public abstract class DateAudit {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    protected Date createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = true, updatable = false)
    protected Date updatedDate;

}
