package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.exception.EssayNotFoundException;
import org.brokers.guiders.web.essay.Essay;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getMemberInfo(@PathVariable Long id) {
        MemberDto.InfoResponse memberDto = memberService.findById(id);
        return ResponseEntity.ok(memberDto);
    }

    @PostMapping("/follow")
    public ResponseEntity<Boolean> follow(@RequestBody String guider, @AuthUser Member member) {
        boolean result = false;
        JSONObject obj = new JSONObject(guider);
        if (member != null) {
            memberService.followGuider(obj.getString("guider"), member);
            result = true;
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/follow")
    public ResponseEntity<Boolean> unfollow(@RequestBody String guider, @AuthUser Member member) {
        JSONObject obj = new JSONObject(guider);
        if (member != null) {
            memberService.unfollowGuider(obj.getString("guider"), member);
        }
        return ResponseEntity.ok(true);
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
