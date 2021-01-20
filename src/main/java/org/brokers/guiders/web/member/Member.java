package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;
    private int gender;
    private String phone;
    private String photo;
    private String ctno;
    private String regDate;

}
