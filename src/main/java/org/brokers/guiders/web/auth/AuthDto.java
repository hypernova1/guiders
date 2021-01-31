package org.brokers.guiders.web.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by melchor
 * Date: 2021/01/31
 * Time: 11:38 PM
 */
public class AuthDto {

    @Getter @Setter
    public static class JoinRequest {
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

    @Getter @Setter
    @ToString
    public static class LoginRequest {
        private String email;
        private String password;
    }

}
