package org.brokers.guiders.web.member.guider;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberDto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "guider")
@DiscriminatorValue("guider")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Guider extends Member {

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
