package org.brokers.guiders.web.mentoring;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

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
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String replay;
        private Long guiderId;
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
