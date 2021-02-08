package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.exception.MentoringNotFoundException;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.guider.GuiderDto;
import org.brokers.guiders.web.member.guider.GuiderRepository;
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
    public void question(MentoringDto.Request request, Member member) {
        Guider guider = guiderRepository.findById(request.getGuiderId())
                .orElseThrow(MemberNotFoundException::new);
        Mentoring mentoring = Mentoring.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .field(request.getField())
                .lang(request.getLang())
                .follower((Follower) member)
                .guider(guider)
                .build();
        mentoringRepository.save(mentoring);
    }

    @Transactional
    public void registerAnswer(MentoringDto.AnswerRequest request) {
        Mentoring mentoring = mentoringRepository.findById(request.getId())
                .orElseThrow(MentoringNotFoundException::new);
        mentoring.setAnswer(request.getAnswer());
        mentoringRepository.save(mentoring);
    }

    public MentoringDto.Response getMentoring(Long id) {
        Mentoring mentoring = mentoringRepository.findById(id).orElseThrow(MentoringNotFoundException::new);
        MentoringDto.Response mentoringDto = modelMapper.map(mentoring, MentoringDto.Response.class);
        GuiderDto guiderDto = modelMapper.map(mentoring.getGuider(), GuiderDto.class);
        mentoringDto.setGuider(guiderDto);
        return mentoringDto;
    }

    public List<MentoringDto.Response> getMyQuestions(String email) {
        Guider guider = guiderRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        List<Mentoring> mentoringList =  mentoringRepository.findByGuider(guider);
        return mentoringList.stream()
                .map(mentoring -> modelMapper.map(mentoring, MentoringDto.Response.class))
                .collect(Collectors.toList());
    }

    public MentoringDto.ListResponse getMentoringList(Member member, Long guiderId) {
        Guider guider = guiderRepository.findById(guiderId)
                .orElseThrow(MemberNotFoundException::new);
        MentoringDto.ListResponse listDto = new MentoringDto.ListResponse();
        listDto.setGuiderName(guider.getName());
        List<Mentoring> mentoringList = mentoringRepository.findByGuiderAndFollower(guider, (Follower) member);
        List<MentoringDto.Response> mentoringDtoList = mentoringList.stream()
                .map(mentoring -> modelMapper.map(mentoring, MentoringDto.Response.class))
                .collect(Collectors.toList());
        listDto.setMentoringList(mentoringDtoList);
        return listDto;
    }

}
