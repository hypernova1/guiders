package org.brokers.guiders.web.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.essay.EssayDto;
import org.brokers.guiders.web.member.Member;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
@EqualsAndHashCode(of = "id", callSuper = false)
public abstract class DateAudit {

    @Id
    @GeneratedValue
    protected Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, updatable = false)
    protected Date createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, updatable = false)
    protected Date updatedDate;

}
