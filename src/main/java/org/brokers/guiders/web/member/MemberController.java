package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.guider.payload.GuiderWithMentoringList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/follow/{id}")
    public ResponseEntity<?> follow(@PathVariable Long id, @AuthUser Member member) {
        memberService.followGuider(id, member);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/follow/{id}")
    public ResponseEntity<?> unfollow(@PathVariable Long id, @AuthUser Member member) {
        if (member != null) {
            memberService.unfollowGuider(id, member);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/following")
    public ResponseEntity<List<GuiderWithMentoringList>> getFollowingList(@AuthUser Member member) {
        List<GuiderWithMentoringList> followList = memberService.getMyGuiderAndQuestion(member);

        return ResponseEntity.ok(followList);
    }

}
