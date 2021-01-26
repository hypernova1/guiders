package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.util.PageCriteria;
import org.brokers.guiders.web.member.FollowerRepository;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.GuiderRepository;
import org.brokers.guiders.web.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EssayService {

    private final GuiderRepository guiderRepository;
    private final EssayRepository essayRepository;
    private final FollowerRepository followerRepository;
    private final RecommendRepository recommendRepository;

    @Transactional
    public void writeEssay(Essay essay) {
        Map<String, String> param = new HashMap<>();
        param.put("email", essay.getWriter().getEmail());
        param.put("type", "guider");
        Guider guider = guiderRepository.findByEmail(param.get("email"))
                .orElseThrow(RuntimeException::new);
        essay.setWriter(guider);
        essay.setField(guider.getField());
        essay.setLang(guider.getLang());
        essayRepository.save(essay);
    }

    public Essay readEssay(Long eno) {
        return essayRepository.findById(eno).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void modifyEssay(Essay essay) {
        essayRepository.save(essay);
    }

    public List<Essay> getEssayList(PageCriteria cri) {
        PageRequest pageRequest = PageRequest.of(cri.getPageStart() - 1, cri.getPerPageNum(), Sort.Direction.DESC);
        Page<Essay> essayPage = essayRepository.findAll(pageRequest);
        return essayPage.getContent();
    }

    public long getEssayCount(PageCriteria cri) {
        return essayRepository.count();
    }

    @Transactional
    public int addRecommend(Map<String, String> map) {
        String id = map.get("eno");
        Essay essay = essayRepository.findById(Long.valueOf(id))
                .orElseThrow(RuntimeException::new);

        Member member = followerRepository.findByEmail(map.get("email"))
                .orElseThrow(RuntimeException::new);

        recommendRepository.findByMemberAndEssay(member, essay)
                .ifPresentOrElse((recommend) -> essay.decrementLikeCount(),
                        () -> {
                            Recommend recommend = Recommend.builder()
                                    .member(member)
                                    .essay(essay)
                                    .build();
                            recommendRepository.save(recommend);
                            essay.incrementLikeCount();
                        }
                );
        return essay.getLikeCount();
    }

    @Transactional
    public void removeEssay(Long eno) {
        essayRepository.deleteById(eno);
    }

    public List<Essay> getTopEssay() {
        return essayRepository.findAllTop6ByOrderByLikeCountDesc();
    }

}
