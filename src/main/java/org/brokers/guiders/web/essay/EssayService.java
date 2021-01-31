package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.EssayNotFoundException;
import org.brokers.guiders.util.PageCriteria;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.Member;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EssayService {

    private final EssayRepository essayRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Long writeEssay(EssayDto.Request request, Member member) {
        Essay essay = Essay.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writer((Guider) member)
                .build();
        return essayRepository.save(essay).getId();
    }

    public Essay getEssay(Long id) {
        return essayRepository.findById(id).orElseThrow(() -> new EssayNotFoundException(id));
    }

    @Transactional
    public void modifyEssay(Long id, EssayDto.Request request) {
        Essay essay = essayRepository.findById(id)
                .orElseThrow(() -> new EssayNotFoundException(id));
        essay.update(request);
    }

    @Transactional
    public List<EssayDto.Response> getEssayList(PageCriteria cri) {
        PageRequest pageRequest = PageRequest.of(cri.getPageStart(), cri.getPerPageNum());
        Page<Essay> essayPage = essayRepository.findAll(pageRequest);
        List<Essay> essayList = essayPage.getContent();
        return essayList.stream().map(essay -> {
            String content = essay.getContent();
            content = content.replaceAll("<[^>]*>", "");
            content = content.replaceAll("&nbsp;", " ");
            content = content.replaceAll("&lt;", "<");
            content = content.replaceAll("&gt;", ">");
            content = content.replaceAll("&amp;", "&");
            essay.setContent(content);
            EssayDto.Response essayDto = modelMapper.map(essay, EssayDto.Response.class);
            essayDto.setWriter(essay.getWriter().getName());
            return essayDto;
        }).collect(Collectors.toList());
    }

    public long getEssayCount(PageCriteria cri) {
        return essayRepository.count();
    }

    @Transactional
    public int toggleLikeEssay(Long id, Member member) {
        Essay essay = getEssay(id);
        member.toggleLikeEssay(essay);
        return essay.getLikeCount();
    }

    @Transactional
    public void removeEssay(Long id) {
        essayRepository.deleteById(id);
    }

    public List<Essay> getTopEssay() {
        return essayRepository.findAllTop6ByOrderByLikeCountDesc();
    }

}
