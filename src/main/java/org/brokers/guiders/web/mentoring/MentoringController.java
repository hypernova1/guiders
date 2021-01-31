package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mentoring")
@RequiredArgsConstructor
public class MentoringController {

    private final MentoringService mentoringService;
    private final MemberService memberService;

    @PostMapping("/answer")
    public String answer(Mentoring mentoring) {
        mentoringService.answer(mentoring);
        return "redirect:/mentoring/" + mentoring.getId();
    }

    @GetMapping("/{id}")
    public String qna(@PathVariable Long id, Model model) {
        Mentoring mentoring = mentoringService.getMentoring(id);
        model.addAttribute("mentoring", mentoring);
        model.addAttribute("guider", mentoring.getGuider());
        return "mypage/mentoring";
    }

    @GetMapping("/list")
    public String mentoringList(String email, @AuthUser Member member, Model model) {
        if (member != null) {
            List<Mentoring> mentoringList = mentoringService.getMentoringList(email, member);
            model.addAttribute("mentoringList", mentoringList);
        }
        return "mypage/mentoringList";
    }

    @GetMapping("/guiders")
    public String guiders() {
        return "guiders/guiders";
    }

    @PostMapping
    public ResponseEntity<Boolean> question(@RequestBody MentoringDto request,
                                            @AuthUser Member member) {
        mentoringService.question(request, member);
        return ResponseEntity.ok(true);
    }
}
