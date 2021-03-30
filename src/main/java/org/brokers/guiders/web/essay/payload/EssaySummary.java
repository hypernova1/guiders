package org.brokers.guiders.web.essay.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EssaySummary {

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
