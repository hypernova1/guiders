package com.guiders.web.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GuiderVO extends MemberVO {

    private String introdution;
    private String currentjob;
    private String dept;
    private String quote;
    private String field;
    private String lang;

}
