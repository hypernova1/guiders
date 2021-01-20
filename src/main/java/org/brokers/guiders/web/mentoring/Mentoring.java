package org.brokers.guiders.web.mentoring;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.member.Guider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Mentoring {

    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Guider guider;

    private String field;

    private String lang;

    private String title;

    private String count;

    private String reply;

    private Integer likeCount;

    private LocalDateTime regDate;

    private LocalDateTime replyDate;


}
