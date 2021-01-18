package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Guider extends Member {

    private String introduction;
    private String currentJob;
    private String dept;
    private String quote;
    private String field;
    private String lang;

}
