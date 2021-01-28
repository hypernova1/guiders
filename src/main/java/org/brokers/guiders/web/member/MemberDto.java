package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter @Setter
    public static class InfoResponse {
        private String email;
        private String name;
    }

}
