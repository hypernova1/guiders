package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<Guider>> getFollowingList(@AuthUser Member member) {
        List<Guider> followList = new ArrayList<>();
        if (member != null) {
            followList = ((Follower) member).getFollowList();
        }
        return ResponseEntity.ok(followList);
    }

}
