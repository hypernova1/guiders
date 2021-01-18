package com.guiders.web.mentoring;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guiders.security.config.UserCustom;
import com.guiders.web.member.GuiderVO;
import com.guiders.web.member.MemberService;

@Controller
@RequestMapping("/mentoring")
@RequiredArgsConstructor
public class MentoringController {

    private final MentoringService mentoringService;
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Boolean> question(@RequestBody MentoringVO mentoringVO,
                                            Authentication authentication) {
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            mentoringVO.setFollower(user.getEmail());
            mentoringService.question(mentoringVO);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/answer")
    public String answer(MentoringVO mentoringVO) {
        mentoringService.answer(mentoringVO);

        return "redirect:/qna/" + mentoringVO.getMtrno();
    }


    @GetMapping("/qna/{mtrno}")
    public String qna(@PathVariable Integer mtrno, Model model) {
        MentoringVO mentoringVO = mentoringService.getMentoring(mtrno);
        GuiderVO guiderVO = memberService.selectByEmail(mentoringVO.getGuider(), "guider");
        model.addAttribute("mentoring", mentoringVO);
        model.addAttribute("guider", guiderVO);
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
}
