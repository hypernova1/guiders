package org.brokers.guiders.web.essay;

import lombok.*;
import org.brokers.guiders.web.common.DateAudit;
import org.brokers.guiders.web.essay.payload.EssayForm;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.guider.Guider;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "essay")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false, of = "id")
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

    @JoinTable(
            name = "like_essay",
            joinColumns = @JoinColumn(name = "essay_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private final Set<Member> likes = new HashSet<>();

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

    public void update(EssayForm essayForm) {
        this.title = essayForm.getTitle();
        this.content = essayForm.getContent();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addLikes(Member member) {
        likes.remove(member);
        member.getLikeEssayList().remove(this);
        this.decrementLikeCount();
    }

    public void removeLikes(Member member) {
        likes.add(member);
        member.getLikeEssayList().add(this);
        this.incrementLikeCount();
    }
}
