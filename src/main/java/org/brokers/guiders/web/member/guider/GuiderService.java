package org.brokers.guiders.web.member.guider;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.MentoringDto;
import org.brokers.guiders.web.mentoring.MentoringRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GuiderService {

    private final MentoringRepository mentoringRepository;
    private final GuiderRepository guiderRepository;
    private final ModelMapper modelMapper;

    public List<MentoringDto.Response> getMentoringList(Guider guider) {
        List<Mentoring> mentoringList = mentoringRepository.findByGuider(guider);
        return mentoringList.stream().map(mentoring -> modelMapper.map(mentoring, MentoringDto.Response.class))
                .collect(Collectors.toList());
    }

    public List<GuiderDto> getGuiderList(int page, Member member) {
        PageRequest pageRequest = PageRequest.of(page - 1, 16);
        Page<Guider> guiderPage = guiderRepository.findAll(pageRequest);
        if (member != null && !member.isGuider()) {
            Follower follower = (Follower) member;
            List<Guider> followList = follower.getFollowList();
            return guiderPage.getContent()
                    .stream().map(guider -> {
                        GuiderDto dto = modelMapper.map(guider, GuiderDto.class);
                        boolean isFollowing = followList.stream()
                                .anyMatch(follow -> follow.getEmail().equals(dto.getEmail()));
                        if (isFollowing) {
                            dto.setFollow(true);
                        }
                        return dto;
                    }).collect(Collectors.toList());
        }
        return guiderPage.getContent().stream()
                .map(guider -> modelMapper.map(guider, GuiderDto.class)).collect(Collectors.toList());
    }

    public GuiderDto getGuider(Long id) {
        Guider guider = guiderRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new);
        return modelMapper.map(guider, GuiderDto.class);
    }

}
