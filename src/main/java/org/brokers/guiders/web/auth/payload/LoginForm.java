package org.brokers.guiders.web.auth.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class LoginForm {

    private String email;
    private String password;

}
