package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.UserCustom;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
            @PathVariable Integer page, Authentication authentication) {
        List<Guider> guiderList;
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            guiderList = memberService.getGuiderList(page, user.getEmail());
        } else {
            guiderList = memberService.getGuiderList(page, null);
        }
        return ResponseEntity.ok(guiderList);
    }

}
