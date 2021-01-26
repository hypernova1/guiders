package org.brokers.guiders.web.mentoring;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.member.Follower;
import org.brokers.guiders.web.member.Guider;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Mentoring {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Guider guider;

    @ManyToOne
    private Follower follower;

    private String field;

    private String lang;

    private String title;

    private String count;

    private String reply;

    private Integer likeCount;

    private LocalDateTime regDate;

    private LocalDateTime replyDate;


}
