package org.brokers.guiders.web.essay;

import lombok.*;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.member.guider.Guider;

import javax.persistence.*;

@Entity
@Table(name = "essay")
@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true, of = "id")
public class Essay extends DateAudit {

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Guider writer;

    @Column(name = "field")
    private String field;

    @Column(name = "language")
    private String language;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "like_count")
    private int likeCount;

    @Builder
    public Essay(Guider writer, String field, String language, String title, String content) {
        this.writer = writer;
        this.field = field;
        this.language = language;
        this.title = title;
        this.content = content;
    }

    public void incrementLikeCount() {
        this.likeCount++;
    }

    public void decrementLikeCount() {
        this.likeCount--;
    }

    public void update(EssayDto.Request request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
