package org.brokers.guiders.web.mentoring;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MentoringDto {

    private String title;
    private String content;
    private Long guiderId;
    private String field;
    private String lang;

}
