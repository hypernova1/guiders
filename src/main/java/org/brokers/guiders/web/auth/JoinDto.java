package org.brokers.guiders.web.auth;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JoinDto {

    private String email;
    private String name;
    private String password;
    private String phone;
    private String birth;
    private String city;
    private String currentJob;
    private String introduction;
    private String language;
    private String department;
    private String quote;
    private String field;
    private String type;

}
