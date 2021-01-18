package com.guiders.web.guiders.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentoringVO {

    private Integer mtrno;
    private String follower;
    private String guider;
    private String field;
    private String lang;
    private String mtitle;
    private String mcontent;
    private String mreply;
    private String regdate;
    private String replydate;
    private Integer likecnt;

}
