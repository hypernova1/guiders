package org.brokers.guiders.web.member.guider;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GuiderDto {

    private Long id;
    private String name;
    private String email;
    private String department;
    private String photoUrl;
    private String currentJob;
    private String introduction;
    private String quote;
    private String lang;
    private String field;

}
