package com.guiders.web.essay;

import com.guiders.web.member.Guider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Essay extends Guider {

    private Integer eno;
    private String email;
    private String field;
    private String lang;
    private String etitle;
    private String econtent;
    private Integer likecnt;
    private String regdate;

}
