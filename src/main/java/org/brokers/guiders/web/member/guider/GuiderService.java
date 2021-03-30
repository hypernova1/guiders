package org.brokers.guiders.web.member.guider;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.payload.GuiderDetail;
import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.MentoringRepository;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;
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

    public List<MentoringDetail> getMentoringList(Guider guider) {
        List<Mentoring> mentoringList = mentoringRepository.findByGuider(guider);
        return mentoringList.stream().map(mentoring -> modelMapper.map(mentoring, MentoringDetail.class))
                .collect(Collectors.toList());
    }

    public List<GuiderDetail> getGuiderList(int page, Member member) {
        PageRequest pageRequest = PageRequest.of(page - 1, 16);
        Page<Guider> guiderPage = guiderRepository.findAll(pageRequest);
        if (member != null && !member.isGuider()) {
            Follower follower = (Follower) member;
            List<Guider> followList = follower.getFollowList();
            return guiderPage.getContent()
                    .stream().map(guider -> {
                        GuiderDetail guiderDetail = modelMapper.map(guider, GuiderDetail.class);
                        boolean isFollowing = followList.stream()
                                .anyMatch(follow -> follow.getEmail().equals(guiderDetail.getEmail()));
                        if (isFollowing) {
                            guiderDetail.setFollow(true);
                        }
                        return guiderDetail;
                    }).collect(Collectors.toList());
        }
        return guiderPage.getContent().stream()
                .map(guider -> modelMapper.map(guider, GuiderDetail.class)).collect(Collectors.toList());
    }

    public GuiderDetail getGuider(Long id) {
        Guider guider = guiderRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new);
        return modelMapper.map(guider, GuiderDetail.class);
    }

}
