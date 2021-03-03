package org.brokers.guiders.web.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class AuthDto {

    @Getter @Setter
    public static class GuiderJoinRequest {
        private String email;
        private String name;
        private String password;
        private String phone;
        private String photoUrl;
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

    @Getter @Setter
    public static class FollowerJoinRequest {
        private String email;
        private String name;
        private String password;
        private String phone;
        private String photoUrl;
        private String birth;
    }

    @Getter @Setter
    @ToString
    public static class LoginRequest {
        private String email;
        private String password;
    }

}
