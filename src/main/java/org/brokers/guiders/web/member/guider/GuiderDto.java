package org.brokers.guiders.web.member.guider;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GuiderDto {

    private String name;
    private String email;
    private String department;
    private String photoUrl;
    private String currentJob;
    private String introduction;

}
