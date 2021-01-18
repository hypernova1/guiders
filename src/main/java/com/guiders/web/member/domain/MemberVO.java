package com.guiders.web.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVO {

    private String email;
    private String password;
    private String mname;
    private int gender;
    private String phone;
    private String photo;
    private String ctno;
    private String regdate;

}
