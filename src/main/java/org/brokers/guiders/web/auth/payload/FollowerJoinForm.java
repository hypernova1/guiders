package org.brokers.guiders.web.auth.payload;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.member.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Arrays;

@Getter
@Setter
public class FollowerJoinForm {

    @Email
    @NotBlank
    @Size(min = 5, max = 30)
    private String email;

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotBlank
    @Size(min = 9, max = 20)
    private String phone;

    @NotBlank
    private String birth;

    @NotBlank
    private int gender;

    @NotBlank
    private String city;

    private String photoUrl;

    public Gender getGender() {
        if (Arrays.asList(1, 3).contains(gender)) {
            return Gender.MALE;
        } else if (Arrays.asList(2, 4).contains(gender)) {
            return Gender.FEMALE;
        }
        return null;
    }

}