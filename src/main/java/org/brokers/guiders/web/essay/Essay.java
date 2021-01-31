package org.brokers.guiders.web.essay;

import lombok.*;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.member.Guider;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Getter @Setter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Essay extends DateAudit {

    @ManyToOne
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
