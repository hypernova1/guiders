package org.brokers.guiders.web.auth;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.member.FollowerRepository;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.GuiderRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final FollowerRepository followerRepository;
    private final GuiderRepository guiderRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(Guider guider) {
        guider.setPassword(bCryptPasswordEncoder.encode(guider.getPassword()));

        if (guider.getQuote() != null) {
            guiderRepository.save(guider);
            return;
        }
//        followerRepository.save(guider);
    }

}
