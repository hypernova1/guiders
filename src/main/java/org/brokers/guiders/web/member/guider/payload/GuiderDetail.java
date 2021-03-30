package org.brokers.guiders.web.member.guider.payload;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class GuiderDetail {

    private Long id;
    private String name;
    private String email;
    private String department;
    private String photoUrl;
    private String currentJob;
    private String introduction;
    private String quote;
    private String lang;
    private String field;
    private boolean isFollow;

}
