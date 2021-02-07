package org.brokers.guiders.web.mentoring;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.member.guider.GuiderDto;

import java.time.LocalDateTime;
import java.util.List;

public class MentoringDto {

    @Getter @Setter
    public static class Request {
        private String title;
        private String content;
        private Long guiderId;
        private String field;
        private String lang;
    }

    @Getter @Setter
    public static class Response {
        private Long id;
        private String title;
        private String content;
        private String writer;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String reply;
        private GuiderDto guider;
        private String field;
        private String lang;
        private LocalDateTime replyDate;
        private LocalDateTime createdDate;
    }

    @Getter @Setter
    public static class ListResponse {
        private String guiderName;
        private List<MentoringDto.Response> mentoringList;
    }

}
