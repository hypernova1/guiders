package org.brokers.guiders.web.member.guider;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.auth.AuthDto;
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

    private String language;

    public static Guider create(AuthDto.JoinRequest request) {
        Guider guider = new Guider();
        guider.email = request.getEmail();
        guider.password = request.getPassword();
        guider.name = request.getName();
        guider.phone = request.getPhone();
        guider.photoUrl = request.getPhotoUrl();
        guider.introduction = request.getIntroduction();
        guider.currentJob = request.getCurrentJob();
        guider.department = request.getDepartment();
        guider.quote = request.getQuote();
        guider.field = request.getField();
        guider.language = request.getLanguage();
        return guider;
    }

    @Override
    public void update(MemberDto.Update memberDto) {
        super.update(memberDto);
        this.introduction = memberDto.getIntroduction();
        this.currentJob = memberDto.getCurrentJob();
        this.department = memberDto.getDepartment();
        this.quote = memberDto.getQuote();
        this.field = memberDto.getField();
        this.language = memberDto.getLang();
    }
}
