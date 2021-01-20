package org.brokers.guiders.web.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@DiscriminatorValue("guider")
public class Guider extends Member {

    @Lob
    private String introduction;

    private String currentJob;

    private String dept;

    private String quote;

    private String field;

    private String lang;

}
