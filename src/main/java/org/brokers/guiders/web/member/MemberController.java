package org.brokers.guiders.web.member;

import org.brokers.guiders.config.security.UserCustom;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/guider")
    @ResponseBody
    public ResponseEntity<Guider> getGuiderInfo(String email) {
        Guider guider = memberService.selectByEmail(email, "guider");

        return ResponseEntity.ok(guider);
    }

    @GetMapping("/guider/list/{page}")
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> getGuiderList(
            @PathVariable Integer page, Authentication authentication) {
        List<Map<String, Object>> guiderList;
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            guiderList = memberService.getGuiderList(page, user.getEmail());
        } else {
            guiderList = memberService.getGuiderList(page, null);
        }
        return ResponseEntity.ok(guiderList);
    }

    @PostMapping("/follow")
    @ResponseBody
    public ResponseEntity<Boolean> follow(@RequestBody String guider, Authentication authentication) {
        boolean result = false;
        JSONObject obj = new JSONObject(guider);
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            memberService.follow(obj.getString("guider"), user.getEmail());
            result = true;
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/follow")
    @ResponseBody
    public ResponseEntity<Boolean> unfollow(@RequestBody String guider, Authentication authentication) {
        JSONObject obj = new JSONObject(guider);
        if (authentication.getPrincipal() != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            memberService.unfollow(obj.getString("guider"), user.getEmail());
        }
        return ResponseEntity.ok(true);
    }
}
