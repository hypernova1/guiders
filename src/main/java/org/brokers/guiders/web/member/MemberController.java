package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.follower.Follower;
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
    public ResponseEntity<?> follow(@PathVariable Long id, @AuthUser Follower follower) {
        memberService.followGuider(id, follower);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/follow/{id}")
    public ResponseEntity<?> unfollow(@PathVariable Long id, @AuthUser Follower follower) {
        if (follower != null) {
            memberService.unfollowGuider(id, follower);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/following")
    public ResponseEntity<List<GuiderWithMentoringList>> getFollowingList(@AuthUser Follower follower) {
        List<GuiderWithMentoringList> followList = memberService.getMyGuiderAndQuestion(follower);

        return ResponseEntity.ok(followList);
    }

}
