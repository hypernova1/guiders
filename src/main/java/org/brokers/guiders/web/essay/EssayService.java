package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.exception.EssayNotFoundException;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.util.PageCriteria;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.GuiderRepository;
import org.brokers.guiders.web.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Transactional
    public void writeEssay(Essay essay) {
        Map<String, String> param = new HashMap<>();
        param.put("email", essay.getWriter().getEmail());
        param.put("type", "guider");
        Guider guider = guiderRepository.findByEmail(param.get("email"))
                .orElseThrow(MemberNotFoundException::new);
        essay.setWriter(guider);
        essay.setField(guider.getField());
        essay.setLang(guider.getLang());
        essayRepository.save(essay);
    }

    public Essay getEssay(Long id) {
        return essayRepository.findById(id).orElseThrow(() -> new EssayNotFoundException(id));
    }

    @Transactional
    public void modifyEssay(Essay essay) {
        essayRepository.save(essay);
    }

    @Transactional
    public List<Essay> getEssayList(PageCriteria cri) {
        PageRequest pageRequest = PageRequest.of(cri.getPageStart(), cri.getPerPageNum());
        Page<Essay> essayPage = essayRepository.findAll(pageRequest);
        return essayPage.getContent();
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
