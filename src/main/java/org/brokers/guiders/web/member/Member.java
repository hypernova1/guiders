package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.mentoring.Mentoring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
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
