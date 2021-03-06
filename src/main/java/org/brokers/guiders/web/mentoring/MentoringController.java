package org.brokers.guiders.web.mentoring;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.follower.Follower;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.mentoring.payload.AnswerForm;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;
import org.brokers.guiders.web.mentoring.payload.MentoringDetailList;
import org.brokers.guiders.web.mentoring.payload.MentoringForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mentoring")
@RequiredArgsConstructor
public class MentoringController {

    private final MentoringService mentoringService;

    @PostMapping
    public ResponseEntity<?> registerQuestion(@RequestBody MentoringForm mentoringForm,
                                              @AuthUser Follower follower) {
        mentoringService.registerQuestion(mentoringForm, follower);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/answer")
    public String registerAnswer(AnswerForm answerForm, @AuthUser Guider guider) {
        mentoringService.registerAnswer(answerForm, guider);
        return "redirect:/mentoring/" + answerForm.getId();
    }

    @GetMapping("/{id}")
    public String questionAndAnswer(@PathVariable Long id, Model model) {
        MentoringDetail mentoring = mentoringService.getMentoringDetail(id);
        model.addAttribute("mentoring", mentoring);
        return "mypage/mentoring";
    }

    @GetMapping("/list")
    public String mentoringList(@AuthUser Follower follower, Long guiderId, Model model) {
        MentoringDetailList mentoringDetailList = mentoringService.getMentoringList(follower, guiderId);
        model.addAttribute("mentoringInfo", mentoringDetailList);
        return "mypage/mentoringList";
    }

}
