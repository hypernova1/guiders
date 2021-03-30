package org.brokers.guiders.web.member.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberUpdateForm {

    private String email;
    private String name;
    private String password;
    private String phone;
    private String photoUrl;
    private String city;
    private String field;
    private String lang;
    private String currentJob;
    private String department;
    private String quote;
    private String introduction;

}
