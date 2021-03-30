package org.brokers.guiders.web.mentoring.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MentoringForm {

    private String title;
    private String content;
    private Long guiderId;
    private String field;
    private String lang;

}
