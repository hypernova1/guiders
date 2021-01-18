package org.brokers.guiders.web.mentoring;

import org.brokers.guiders.config.security.UserCustom;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mentoring")
@RequiredArgsConstructor
public class MentoringController {

    private final MentoringService mentoringService;
    private final MemberService memberService;

    @PostMapping("/answer")
    public String answer(Mentoring mentoring) {
        mentoringService.answer(mentoring);

        return "redirect:/qna/" + mentoring.getMtrno();
    }


    @GetMapping("/qna/{mtrno}")
    public String qna(@PathVariable Integer mtrno, Model model) {
        Mentoring mentoring = mentoringService.getMentoring(mtrno);
        Guider guider = memberService.selectByEmail(mentoring.getGuider(), "guider");
        model.addAttribute("mentoring", mentoring);
        model.addAttribute("guider", guider);
        return "mypage/qna";
    }

    @GetMapping("/list")
    public String mentoringList(String email, Authentication authentication, Model model) {
        if (authentication.getPrincipal() != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            List<Map<String, Object>> mentorings =
                    mentoringService.getMentoringList(email, user.getEmail());
            model.addAttribute("mentorings", mentorings);
        }

        return "mypage/mentoringList";
    }

    @GetMapping("/guiders")
    public String guiders() {
        return "guiders/guiders";
    }

    @PostMapping
    public ResponseEntity<Boolean> question(@RequestBody Mentoring mentoring,
                                            Authentication authentication) {
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            mentoring.setFollower(user.getEmail());
            mentoringService.question(mentoring);
        }

        return ResponseEntity.ok(true);
    }
}
