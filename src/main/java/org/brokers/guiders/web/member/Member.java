package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private String email;
    private String password;
    private String mname;
    private int gender;
    private String phone;
    private String photo;
    private String ctno;
    private String regdate;

}
