package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.guider.GuiderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/follow/${id}")
    public ResponseEntity<Boolean> follow(@PathVariable Long id, @AuthUser Member member) {
        if (member != null) {
            memberService.followGuider(id, member);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/follow/{id}")
    public ResponseEntity<Boolean> unfollow(@PathVariable Long id, @AuthUser Member member) {
        if (member != null) {
            memberService.unfollowGuider(id, member);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/following")
    public ResponseEntity<List<GuiderDto.WithMentoring>> getFollowingList(@AuthUser Member member) {
        List<GuiderDto.WithMentoring> followList = memberService.getMyGuiderAndQuestion(member);

        return ResponseEntity.ok(followList);
    }

}
