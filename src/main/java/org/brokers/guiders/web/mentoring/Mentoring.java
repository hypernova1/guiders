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
    protected Long id;

    @OneToOne
    @Column(name = "guider_id", nullable = false, updatable = false)
    private Guider guider;

    @OneToOne
    @Column(name = "follower_id", nullable = false, updatable = false)
    private Follower follower;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @Lob
    @Column(name = "answer")
    private String answer;

    @Column(name = "field")
    private String field;

    @Column(name = "lang")
    private String language;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "answer_date")
    private LocalDateTime answerDate;

    @Builder
    public Mentoring(String title, String content, Guider guider, Follower follower, String field, String language) {
        this.title = title;
        this.content = content;
        this.guider = guider;
        this.follower = follower;
        this.field = field;
        this.language = language;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
        this.answerDate = LocalDateTime.now();
    }
}
