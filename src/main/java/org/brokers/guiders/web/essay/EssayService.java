package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.EssayNotFoundException;
import org.brokers.guiders.exception.EssayOwnershipException;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.guider.Guider;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public EssayDto.DetailResponse getEssay(Long id) {
        Essay essay = essayRepository.findById(id).orElseThrow(() -> new EssayNotFoundException(id));
        EssayDto.DetailResponse essayDto = modelMapper.map(essay, EssayDto.DetailResponse.class);
        essayDto.setWriter(essay.getWriter().getName());
        essayDto.setEmail(essay.getWriter().getEmail());
        return essayDto;
    }

    @Transactional
    public void modifyEssay(Long id, EssayDto.Request request, Member member) {
        Essay essay = essayRepository.findById(id)
                .orElseThrow(() -> new EssayNotFoundException(id));
        if (!essay.getWriter().equals(member)) {
            throw new EssayOwnershipException();
        }
        essay.update(request);
    }

    @Transactional
    public Page<EssayDto.Response> getEssayList(int page, String keyword) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Essay> essayPage = essayRepository.searchByKeyword(keyword, pageRequest);

        return essayPage.map(essay -> {
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
        });
    }

    @Transactional
    public void removeEssay(Long id, Member member) {
        Essay essay = essayRepository.findById(id)
                .orElseThrow(() -> new EssayNotFoundException(id));

        if (!essay.getWriter().equals(member)) {
            throw new EssayOwnershipException();
        }
        essayRepository.delete(essay);
    }

    public List<EssayDto.Response> getTopEssay() {
        List<Essay> topEssayList = essayRepository.findTop6ByOrderByLikeCountDesc();
        Pattern pattern = Pattern.compile("\\< ?img(.*?)\\>");
        return topEssayList.stream()
                .map(essay -> {
                    essay.setContent(essay.getContent().replaceAll("\\< ?img(.*?)\\>", ""));
                    EssayDto.Response essayDto = modelMapper.map(essay, EssayDto.Response.class);
                    Matcher matcher = pattern.matcher(essayDto.getContent());
                    String image = "https://t1.daumcdn.net/cfile/tistory/1112763C4F78EAB610";
                    if (matcher.find()) {
                        image = matcher.group();
                    }
                    essayDto.setImage(image);
                    return essayDto;
                })
                .collect(Collectors.toList());
    }

    public List<EssayDto.DetailResponse> getLikeEssayList(Member member) {
        List<Essay> likeEssayList = member.getLikeEssayList();
        return likeEssayList.stream()
                .map(likeEssay -> modelMapper.map(likeEssay, EssayDto.DetailResponse.class))
                .collect(Collectors.toList());
    }

}
