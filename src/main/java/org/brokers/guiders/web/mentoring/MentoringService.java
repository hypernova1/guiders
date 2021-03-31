package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.exception.MentoringNotFoundException;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.guider.GuiderRepository;
import org.brokers.guiders.web.member.guider.payload.GuiderDetail;
import org.brokers.guiders.web.mentoring.payload.AnswerForm;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;
import org.brokers.guiders.web.mentoring.payload.MentoringDetailList;
import org.brokers.guiders.web.mentoring.payload.MentoringForm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final GuiderRepository guiderRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void registerQuestion(MentoringForm mentoringForm, Follower follower) {
        Guider guider = guiderRepository.findById(mentoringForm.getGuiderId())
                .orElseThrow(MemberNotFoundException::new);
        Mentoring mentoring = Mentoring.builder()
                .title(mentoringForm.getTitle())
                .content(mentoringForm.getContent())
                .field(mentoringForm.getField())
                .language(mentoringForm.getLang())
                .follower(follower)
                .guider(guider)
                .build();
        mentoringRepository.save(mentoring);
    }

    @Transactional
    public void registerAnswer(AnswerForm answerForm, Guider guider) {
        Mentoring mentoring = mentoringRepository.findById(answerForm.getId())
                .orElseThrow(MentoringNotFoundException::new);
        mentoring.registerAnswer(answerForm.getAnswer(), guider);
        mentoringRepository.save(mentoring);
    }

    public MentoringDetail getMentoringDetail(Long id) {
        Mentoring mentoring = mentoringRepository.findById(id).orElseThrow(MentoringNotFoundException::new);
        MentoringDetail mentoringDetail = modelMapper.map(mentoring, MentoringDetail.class);
        GuiderDetail guiderDetail = modelMapper.map(mentoring.getGuider(), GuiderDetail.class);
        mentoringDetail.setGuider(guiderDetail);
        return mentoringDetail;
    }

    public List<MentoringDetail> getMyQuestions(String email) {
        Guider guider = guiderRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        List<Mentoring> mentoringList =  mentoringRepository.findByGuider(guider);
        return mentoringList.stream()
                .map(mentoring -> modelMapper.map(mentoring, MentoringDetail.class))
                .collect(Collectors.toList());
    }

    public MentoringDetailList getMentoringList(Follower follower, Long guiderId) {
        Guider guider = guiderRepository.findById(guiderId)
                .orElseThrow(MemberNotFoundException::new);

        List<MentoringDetail> mentoringDetailList = mentoringRepository.findByGuiderAndFollower(guider, follower)
                .stream()
                .map(mentoring -> modelMapper.map(mentoring, MentoringDetail.class))
                .collect(Collectors.toList());

        MentoringDetailList mentoringList = new MentoringDetailList();
        mentoringList.setGuiderName(guider.getName());
        mentoringList.setMentoringList(mentoringDetailList);
        return mentoringList;
    }

}
