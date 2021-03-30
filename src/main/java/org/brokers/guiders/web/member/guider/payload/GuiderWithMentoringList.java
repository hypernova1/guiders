package org.brokers.guiders.web.member.guider.payload;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class GuiderWithMentoringList {

    private Long id;
    private String email;
    private String name;
    private String photoUrl;
    private String currentJob;
    private String department;
    private String field;
    private String lang;
    private List<MentoringDetail> mentoringList = new ArrayList<>();

    public void addMentoring(MentoringDetail mentoringDetail) {
        mentoringList.add(mentoringDetail);
    }

}
