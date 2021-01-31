package org.brokers.guiders.web.mentoring;

import lombok.*;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mentoring")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentoring extends DateAudit {

    @Id
    @GeneratedValue
    @Column(name = "mentoring_id")
    protected Long id;

    @ManyToOne
    private Guider guider;

    @ManyToOne
    private Follower follower;

    private String field;

    private String lang;

    private String title;

    private String content;

    private String reply;

    private Integer likeCount;

    private LocalDateTime replyDate;

    @Builder
    public Mentoring(String title, String content, Guider guider, Follower follower, String field, String lang) {
        this.title = title;
        this.content = content;
        this.guider = guider;
        this.follower = follower;
        this.field = field;
        this.lang = lang;
    }
}
