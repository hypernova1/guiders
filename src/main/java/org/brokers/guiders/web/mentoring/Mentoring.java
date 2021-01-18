package org.brokers.guiders.web.mentoring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentoring {

    private Integer id;
    private String follower;
    private String guider;
    private String field;
    private String lang;
    private String title;
    private String count;
    private String reply;
    private String regDate;
    private String replyDate;
    private Integer likeCount;

}
