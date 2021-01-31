package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter @Setter
    public static class InfoResponse {
        private String email;
        private String name;
    }

    @Getter @Setter
    public static class Update {
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

}
