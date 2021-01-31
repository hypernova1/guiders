package org.brokers.guiders.web.essay;

import lombok.Getter;
import lombok.Setter;

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
    }

    @Getter @Setter
    public static class DetailResponse {

    }

}
