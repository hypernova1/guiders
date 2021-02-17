package org.brokers.guiders.web.essay;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class EssayDto {

    @Getter @Setter
    public static class Request {
        private String title;
        private String content;
    }

    @Getter @Setter
    public static class Response {
        private Long id;
        private String writer;
        private String title;
        private String content;
        private String field;
        private String writerPhotoUrl;
        private int likeCount;
        private String createdDate;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String image;
    }

    @Getter @Setter
    @ToString
    public static class DetailResponse {
        private Long id;
        private String title;
        private String content;
        private String writer;
        private String email;
        private String field;
        private String lang;
        private String writerPhotoUrl;
        private int likeCount;
        private String createdDate;
    }

}
