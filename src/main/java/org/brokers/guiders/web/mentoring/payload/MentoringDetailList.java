package org.brokers.guiders.web.mentoring.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MentoringDetailList {

    private String guiderName;
    private List<MentoringDetail> mentoringList;

}
