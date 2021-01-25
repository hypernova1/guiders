package org.brokers.guiders.web.mypage;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.essay.EssayRepository;
import org.brokers.guiders.web.member.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final EssayRepository essayRepository;
    private final MemberRepository<Member> memberRepository;
    private final FollowerRepository followerRepository;

    public List<Essay> getMyLikeEssay(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        return member.getLikeEssay();
    }

    public String getEssayContent(Long eno) {
        return essayRepository.findById(eno)
                .orElseThrow(RuntimeException::new).getContent();
    }

    public List<Guider> getMyGuiderList(String email) {
        Follower follower = followerRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);

        return follower.getGuiderList();
    }

}
