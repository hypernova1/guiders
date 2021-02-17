package org.brokers.guiders.web.essay;

import lombok.*;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.guider.Guider;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "essay")
@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true, of = "id")
public class Essay extends DateAudit {

    @Id
    @GeneratedValue
    @Column(name = "essay_id")
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Guider writer;

    private String field;

    private String lang;

    private String title;

    @Lob
    private String content;

    private int likeCount;

    @Builder
    public Essay(Guider writer, String field, String lang, String title, String content) {
        this.writer = writer;
        this.field = field;
        this.lang = lang;
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
