package org.brokers.guiders.web.essay;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.member.Guider;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Entity
@ToString
public class Essay extends DateAudit {

    @ManyToOne
    private Guider writer;

    private String field;

    private String lang;

    private String title;

    @Lob
    private String content;

    private int likeCount;

    public void incrementLikeCount() {
        this.likeCount++;
    }

    public void decrementLikeCount() {
        this.likeCount--;
    }
}
