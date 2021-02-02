package org.brokers.guiders.web.member.guider;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/guider")
@RequiredArgsConstructor
public class GuiderController {

    private final MemberService memberService;

    @GetMapping("/list")
    public String guiders() {
        return "guiders/guiders";
    }

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
