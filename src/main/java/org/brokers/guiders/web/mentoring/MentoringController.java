package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.mentoring.payload.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mentoring")
@RequiredArgsConstructor
public class MentoringController {

    private final MentoringService mentoringService;

    @PostMapping("/answer")
    public String answer(AnswerForm answerForm) {
        mentoringService.registerAnswer(answerForm);
        return "redirect:/mentoring/" + answerForm.getId();
    }

    @GetMapping("/{id}")
    public String questionAndAnswer(@PathVariable Long id, Model model) {
        MentoringDetail mentoring = mentoringService.getMentoring(id);
        model.addAttribute("mentoring", mentoring);
        return "mypage/mentoring";
    }

    @GetMapping("/list")
    public String mentoringList(@AuthUser Member member, Long guiderId, Model model) {
        MentoringDetailList mentoringDetailList = mentoringService.getMentoringList(member, guiderId);
        model.addAttribute("mentoringInfo", mentoringDetailList);
        return "mypage/mentoringList";
    }

    @PostMapping
    public ResponseEntity<?> question(@RequestBody MentoringForm mentoringForm,
                                            @AuthUser Member member) {
        mentoringService.question(mentoringForm, member);
        return ResponseEntity.ok().build();
    }
}
