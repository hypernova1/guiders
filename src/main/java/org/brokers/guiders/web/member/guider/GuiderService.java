package org.brokers.guiders.web.member.guider;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.MentoringDto;
import org.brokers.guiders.web.mentoring.MentoringRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GuiderService {

    private final MentoringRepository mentoringRepository;
    private final ModelMapper modelMapper;

    public List<MentoringDto.Response> getMentoringList(Guider guider) {
        List<Mentoring> mentoringList = mentoringRepository.findByGuider(guider);
        return mentoringList.stream().map(mentoring -> modelMapper.map(mentoring, MentoringDto.Response.class))
                .collect(Collectors.toList());
    }

}
