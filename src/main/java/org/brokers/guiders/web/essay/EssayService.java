package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.EssayNotFoundException;
import org.brokers.guiders.exception.EssayOwnershipException;
import org.brokers.guiders.web.essay.payload.EssayDetail;
import org.brokers.guiders.web.essay.payload.EssaySummary;
import org.brokers.guiders.web.essay.payload.EssayForm;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.guider.Guider;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
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
    public Long writeEssay(EssayForm essayForm, Guider guider) {
        Essay essay = Essay.builder()
                .title(essayForm.getTitle())
                .content(essayForm.getContent())
                .writer(guider)
                .build();
        return essayRepository.save(essay).getId();
    }

    public EssayDetail getEssay(Long id) {
        Essay essay = essayRepository.findById(id).orElseThrow(() -> new EssayNotFoundException(id));
        EssayDetail essayDetail = modelMapper.map(essay, EssayDetail.class);
        essayDetail.setWriter(essay.getWriter().getName());
        essayDetail.setEmail(essay.getWriter().getEmail());
        essayDetail.setContent(essay.getContent().replace("<br>", "\n"));
        return essayDetail;
    }

    @Transactional
    public void modifyEssay(Long id, EssayForm essayForm, Guider guider) {
        Essay essay = essayRepository.findById(id)
                .orElseThrow(() -> new EssayNotFoundException(id));
        if (!essay.getWriter().equals(guider)) {
            throw new EssayOwnershipException();
        }
        essay.update(essayForm);
    }

    @Transactional
    public Page<EssaySummary> getEssayList(int page, String keyword) {
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
            EssaySummary essaySummary = modelMapper.map(essay, EssaySummary.class);
            essaySummary.setWriter(essay.getWriter().getName());
            return essaySummary;
        });
    }

    @Transactional
    public void removeEssay(Long id, Guider guider) {
        Essay essay = essayRepository.findById(id)
                .orElseThrow(() -> new EssayNotFoundException(id));

        if (!essay.getWriter().equals(guider)) {
            throw new EssayOwnershipException();
        }
        essayRepository.delete(essay);
    }

    public List<EssaySummary> getTopEssay() {
        List<Essay> topEssayList = essayRepository.findTop6ByOrderByLikeCountDesc();
        Pattern pattern = Pattern.compile("\\< ?img(.*?)\\>");
        return topEssayList.stream()
                .map(essay -> {
                    essay.setContent(essay.getContent().replaceAll("\\< ?img(.*?)\\>", ""));
                    EssaySummary essaySummary = modelMapper.map(essay, EssaySummary.class);
                    Matcher matcher = pattern.matcher(essaySummary.getContent());
                    String image = "https://t1.daumcdn.net/cfile/tistory/1112763C4F78EAB610";
                    if (matcher.find()) {
                        image = matcher.group();
                    }
                    essaySummary.setImage(image);
                    return essaySummary;
                })
                .collect(Collectors.toList());
    }

    public List<EssayDetail> getLikeEssayList(Member member) {
        Set<Essay> likeEssayList = member.getLikeEssayList();
        return likeEssayList.stream()
                .map(likeEssay -> modelMapper.map(likeEssay, EssayDetail.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public int toggleLikeEssay(Long id, Member member) {
        Essay essay = essayRepository.findById(id)
                .orElseThrow(() -> new EssayNotFoundException(id));
        Set<Member> likes = essay.getLikes();

        if (likes.contains(member)) {
            essay.addLikes(member);

        } else {
            essay.removeLikes(member);
        }
        essayRepository.save(essay);
        return essay.getLikeCount();
    }

}
