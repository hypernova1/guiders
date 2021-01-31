package org.brokers.guiders.api;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.member.MemberDto;
import org.brokers.guiders.web.member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userApi")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberInfo(@PathVariable Long id) {
        MemberDto.InfoResponse memberDto = memberService.findById(id);
        return ResponseEntity.ok(memberDto);
    }

}
