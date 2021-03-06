package org.brokers.guiders.web.member.guider;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.auth.AuthDto;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberDto;

import javax.persistence.*;

@Entity
@Table(name = "guider")
@DiscriminatorValue("guider")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Guider extends Member {

    @Lob
    @Column(name = "introduction")
    private String introduction;

    @Column(name = "current_job")
    private String currentJob;

    @Column(name = "department")
    private String department;

    @Column(name = "quote")
    private String quote;

    @Column(name = "field")
    private String field;

    @Column(name = "language")
    private String language;

    public static Guider create(AuthDto.GuiderJoinRequest request) {
        Guider guider = new Guider();
        guider.email = request.getEmail();
        guider.password = request.getPassword();
        guider.name = request.getName();
        guider.birth = request.getBirth();
        guider.gender = request.getGender();
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
