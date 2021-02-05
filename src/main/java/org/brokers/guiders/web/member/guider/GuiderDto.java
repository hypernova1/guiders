package org.brokers.guiders.web.member.guider;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.mentoring.MentoringDto;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class GuiderDto {

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

    @Getter @Setter
    public static class WithMentoring {

        private Long id;
        private String email;
        private String name;
        private String photoUrl;
        private String currentJob;
        private String department;
        private String field;
        private String lang;
        private List<MentoringDto> mentoringList = new ArrayList<>();

        public void addMentoring(MentoringDto mentoringDto) {
            mentoringList.add(mentoringDto);
        }

    }


}
