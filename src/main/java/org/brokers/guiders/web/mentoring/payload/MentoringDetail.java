package org.brokers.guiders.web.mentoring.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.member.guider.payload.GuiderDetail;

@Getter @Setter
public class MentoringDetail {

    private Long id;
    private String title;
    private String content;
    private String writer;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String answer;
    private GuiderDetail guider;
    private String field;
    private String lang;
    private String answerDate;
    private String createdDate;

}
