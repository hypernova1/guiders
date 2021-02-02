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
    public ResponseEntity<GuiderDto> getGuiderInfo(@PathVariable Long id) {
        GuiderDto guider = memberService.getGuider(id);
        return ResponseEntity.ok(guider);
    }

    @GetMapping
    public ResponseEntity<List<GuiderDto>> getGuiderList(
            @RequestParam(defaultValue = "1") Integer page, @AuthUser Member member) {
        List<GuiderDto> guiderList = memberService.getGuiderList(page, member);
        return ResponseEntity.ok(guiderList);
    }

}
