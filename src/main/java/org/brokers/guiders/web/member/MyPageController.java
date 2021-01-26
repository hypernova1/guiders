package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.UserCustom;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.essay.EssayService;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.MemberService;
import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.MentoringService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final EssayService essayService;
    private final MentoringService mentoringService;
    private final MemberService memberService;

    @GetMapping("/likeEssay")
    public String likeEssay(Authentication authentication, Model model) {
        List<Essay> list;
        if (authentication.isAuthenticated()) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            list = memberService.getMyLikeEssay(user.getEmail());
            model.addAttribute("essayList", list);
        }
        return "mypage/likeEssay";
    }

    @GetMapping("/myGuider")
    public String myGuiders() {
        return "mypage/myGuider";
    }

    @GetMapping("myGuiders")
    @ResponseBody
    public ResponseEntity<List<Guider>> myGuiderList(Authentication authentication) {
        List<Guider> list = new ArrayList<>();
        if (authentication.isAuthenticated()) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            list = memberService.getMyGuiderList(user.getEmail());
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/likeEssay/{eno}")
    @ResponseBody
    public String getEssay(@PathVariable("eno") Long eno) {
        return essayService.getEssayContent(eno);
    }

    @GetMapping("/guider/{email}")
    @ResponseBody
    public ResponseEntity<Guider> guider(@PathVariable String email) {
        return ResponseEntity.ok((Guider) memberService.selectByEmail(email, "guider"));
    }

    @GetMapping("/questions")
    public String questions(Authentication authentication, Model model) {
        List<Mentoring> mentoringList = null;
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            mentoringList = mentoringService.getMyQuestions(user.getEmail());
        }
        model.addAttribute("mentoringList", mentoringList);
        return "mypage/questions";
    }

    @GetMapping("/edit")
    public String edit(Model model, Authentication authentication) {
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            String type = "guider";
            if (user.getAuthorities().toString().equals("[ROLE_MEMBER]")) {
                type = "member";
            }
            Guider vo = (Guider) memberService.selectByEmail(user.getEmail(), type);
            model.addAttribute("vo", vo);
        }

        return "mypage/edit";
    }

    @PostMapping("/edit")
    public String edit(Guider vo, Authentication authentication) {
        if (vo != null && authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            vo.setPassword(vo.getPassword().trim());
            vo.setEmail(user.getEmail());

            memberService.modifyMember(vo);
        }
        return "redirect:/mypage/edit";
    }

}
