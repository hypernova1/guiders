package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.mentoring.Mentoring;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@DiscriminatorValue("guider")
public class Guider extends Member {

    @OneToMany
    private final List<Mentoring> mentoringList = new ArrayList<>();

    @Lob
    private String introduction;

    private String currentJob;

    private String department;

    private String quote;

    private String field;

    private String lang;

}
