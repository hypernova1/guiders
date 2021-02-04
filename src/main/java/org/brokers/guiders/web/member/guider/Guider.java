package org.brokers.guiders.web.member.guider;

import lombok.Getter;
import lombok.Setter;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberDto;
import org.brokers.guiders.web.mentoring.Mentoring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guider")
@Getter @Setter
@DiscriminatorValue("guider")
public class Guider extends Member {

    @OneToMany(mappedBy = "id")
    private final List<Mentoring> mentoringList = new ArrayList<>();

    @Lob
    private String introduction;

    private String currentJob;

    private String department;

    private String quote;

    private String field;

    private String lang;

    @Override
    public void update(MemberDto.Update memberDto) {
        super.update(memberDto);
        this.introduction = memberDto.getIntroduction();
        this.currentJob = memberDto.getCurrentJob();
        this.department = memberDto.getDepartment();
        this.quote = memberDto.getQuote();
        this.field = memberDto.getField();
        this.lang = memberDto.getLang();
    }
}
