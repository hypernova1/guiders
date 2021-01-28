package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/guider")
    @ResponseBody
    public ResponseEntity<Member> getGuiderInfo(String email) {
        Guider guider = (Guider) memberService.selectByEmail(email, "guider");

        return ResponseEntity.ok(guider);
    }

    @GetMapping("/guider/list/{page}")
    @ResponseBody
    public ResponseEntity<List<Guider>> getGuiderList(
            @PathVariable Integer page, @AuthUser Member member) {
        List<Guider> guiderList;
        if (member != null) {
            guiderList = memberService.getGuiderList(page, member);
        } else {
            guiderList = memberService.getGuiderList(page, null);
        }
        return ResponseEntity.ok(guiderList);
    }

    @PostMapping("/follow")
    @ResponseBody
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
    @ResponseBody
    public ResponseEntity<Boolean> unfollow(@RequestBody String guider, @AuthUser Member member) {
        JSONObject obj = new JSONObject(guider);
        if (member != null) {
            memberService.unfollowGuider(obj.getString("guider"), member);
        }
        return ResponseEntity.ok(true);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getMemberInfo(@PathVariable Long id) {
        MemberDto.InfoResponse memberDto = memberService.findById(id);
        return ResponseEntity.ok(memberDto);
    }

}
