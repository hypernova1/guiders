package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.exception.MentoringNotFoundException;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.guider.GuiderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final GuiderRepository guiderRepository;
    private final ModelMapper modelMapper;

    public void question(MentoringDto request, Member member) {
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

    public void answer(Mentoring mentoring) {
        mentoringRepository.save(mentoring);
    }

    public Mentoring getMentoring(Long id) {
        return mentoringRepository.findById(id).orElseThrow(MentoringNotFoundException::new);
    }

    public Stream<MentoringDto> getMyQuestions(String email) {
        Guider guider = guiderRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);

        List<Mentoring> mentoringList =  mentoringRepository.findByGuider(guider);
        return mentoringList.stream().map(mentoring -> modelMapper.map(mentoring, MentoringDto.class));
    }

    public List<MentoringDto> getMentoringList(Member member, Long guiderId) {
        Guider guider = guiderRepository.findById(guiderId)
                .orElseThrow(MemberNotFoundException::new);
        List<Mentoring> mentoringList = mentoringRepository.findByGuiderAndFollower(guider, (Follower) member);
        return mentoringList.stream()
                .map(mentoring -> modelMapper.map(mentoring, MentoringDto.class))
                .collect(Collectors.toList());
    }

}
