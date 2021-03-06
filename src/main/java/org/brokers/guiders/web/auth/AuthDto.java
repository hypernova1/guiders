package org.brokers.guiders.web.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.brokers.guiders.web.member.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Arrays;

public class AuthDto {

    @Getter @Setter
    public static class GuiderJoinRequest {

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
        @Size(min = 6, max = 6)
        private String birth;

        @NotBlank
        @Size(min = 1, max = 1)
        private int gender;

        @NotBlank
        @Size(min = 1, max = 20)
        private String city;

        @NotBlank
        private String currentJob;

        @NotBlank
        private String introduction;

        @NotBlank
        private String language;

        @NotBlank
        private String department;

        @NotBlank
        private String quote;

        @NotBlank
        private String field;

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

    @Getter @Setter
    public static class FollowerJoinRequest {

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

    @Getter @Setter
    @ToString
    public static class LoginRequest {
        private String email;
        private String password;
    }

}
