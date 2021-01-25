package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.mentoring.Mentoring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Member {

    @Id @GeneratedValue
    protected Long id;
    protected String email;
    protected String password;
    protected String name;
    protected int gender;
    protected String phone;
    protected String photo;
    protected String ctno;
    protected String regDate;
    @OneToMany
    protected final List<Essay> likeEssay = new ArrayList<>();
}
