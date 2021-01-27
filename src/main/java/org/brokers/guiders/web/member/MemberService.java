package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.follow.Follow;
import org.brokers.guiders.web.follow.FollowRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final FollowerRepository followerRepository;
    private final GuiderRepository guiderRepository;
    private final FollowRepository followRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void modifyMember(Guider guider) {
        if (!guider.getPassword().isEmpty()) {
            String password = passwordEncoder.encode(guider.getPassword());
            guider.setPassword(password);
        }
        guiderRepository.save(guider);
    }

    public List<String> getAuthList(String email) {
        //TODO: 권한 리스트
        return Collections.emptyList();
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
    }

    public Member selectByEmail(String email, String type) {
        if (type.equals("guider")) {
            return guiderRepository.findByEmail(email)
                    .orElseThrow(RuntimeException::new);
        }
        return followerRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
    }


    public List<Guider> getGuiderList(Integer page, String email) {
        if (page == null) page = 0;

        PageRequest pageRequest = PageRequest.of(page, 16);
        Page<Guider> guiderPage = guiderRepository.findAll(pageRequest);

        return guiderPage.getContent();
    }

    public List<Essay> getMyLikeEssay(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        return member.getLikeEssay();
    }

    public List<Guider> getMyGuiderList(String email) {
        Follower follower = followerRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);

        return follower.getGuiderList();
    }

}
