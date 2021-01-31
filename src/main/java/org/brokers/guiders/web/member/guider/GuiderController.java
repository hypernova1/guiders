package org.brokers.guiders.web.member.guider;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guider")
@RequiredArgsConstructor
public class GuiderController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<Member> getGuiderInfo(String email) {
        Guider guider = (Guider) memberService.findByEmail(email);
        return ResponseEntity.ok(guider);
    }

    @GetMapping
    public ResponseEntity<List<Guider>> getGuiderList(
            @RequestParam(defaultValue = "1") Integer page, @AuthUser Member member) {
        List<Guider> guiderList;
        if (member != null) {
            guiderList = memberService.getGuiderList(page, member);
        } else {
            guiderList = memberService.getGuiderList(page, null);
        }
        return ResponseEntity.ok(guiderList);
    }

    @GetMapping("/guider/{email}")
    @ResponseBody
    public ResponseEntity<Guider> guider(@PathVariable String email) {
        return ResponseEntity.ok((Guider) memberService.findByEmail(email));
    }

}
