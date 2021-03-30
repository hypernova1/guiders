package org.brokers.guiders.web.essay.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EssayDetail {

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
