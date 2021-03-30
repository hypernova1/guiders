package org.brokers.guiders.web.member.guider;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.brokers.guiders.web.auth.payload.GuiderJoinForm;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.payload.MemberUpdateForm;

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

    public static Guider create(GuiderJoinForm joinForm) {
        Guider guider = new Guider();
        guider.email = joinForm.getEmail();
        guider.password = joinForm.getPassword();
        guider.name = joinForm.getName();
        guider.birth = joinForm.getBirth();
        guider.gender = joinForm.getGender();
        guider.phone = joinForm.getPhone();
        guider.photoUrl = joinForm.getPhotoUrl();
        guider.introduction = joinForm.getIntroduction();
        guider.currentJob = joinForm.getCurrentJob();
        guider.department = joinForm.getDepartment();
        guider.quote = joinForm.getQuote();
        guider.field = joinForm.getField();
        guider.language = joinForm.getLanguage();
        return guider;
    }

    @Override
    public void update(MemberUpdateForm updateForm) {
        super.update(updateForm);
        this.introduction = updateForm.getIntroduction();
        this.currentJob = updateForm.getCurrentJob();
        this.department = updateForm.getDepartment();
        this.quote = updateForm.getQuote();
        this.field = updateForm.getField();
        this.language = updateForm.getLang();
    }
}
