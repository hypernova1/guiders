package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.brokers.guiders.util.PageCriteria;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.GuiderRepository;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.FollowerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EssayService {

    private final GuiderRepository guiderRepository;
    private final EssayRepository essayRepository;
    private final FollowerRepository followerRepository;
    private final RecommendRepository recommendRepository;
    private final SqlSession sqlSession;

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

    public List<Essay> getEssayList(Integer startNum, PageCriteria cri) {
        return sqlSession.getMapper(EssayDAO.class).selectEssayList(startNum, cri);
    }

    @Transactional
    public int addRecommend(Map<String, String> map) {
        String eno = map.get("eno");
        Essay essay = essayRepository.findById(Long.valueOf(eno))
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

    public void removeEssay(Long eno) {
        essayRepository.deleteById(eno);
    }

    public Integer getEssayCount(PageCriteria cri) {
        return sqlSession.getMapper(EssayDAO.class).selectEssayCount(cri);
    }

    public List<Essay> getTopEssay() {
        return essayRepository.findTop6OrderByLikeCountDesc();
    }

}
