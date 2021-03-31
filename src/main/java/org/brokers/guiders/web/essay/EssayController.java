package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.essay.payload.EssayDetail;
import org.brokers.guiders.web.essay.payload.EssaySummary;
import org.brokers.guiders.web.essay.payload.EssayForm;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.guider.Guider;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/essay")
@RequiredArgsConstructor
public class EssayController {

    private final EssayService essayService;

    @GetMapping("/write")
    public String writeEssay() {
        return "essay/write";
    }

    @PostMapping("/write")
    public String writeEssay(EssayForm essayForm, @AuthUser Guider guider) {
        Long id = essayService.writeEssay(essayForm, guider);
        return "redirect:/essay/detail/" + id;
    }

    @GetMapping("/list")
    public String goEssayListPage(Model model,
                                  @RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "") String keyword) {
        Page<EssaySummary> essayPage = essayService.getEssayList(page - 1, keyword);
        model.addAttribute("essayPage", essayPage);
        return "essay/list";
    }

    @GetMapping("/detail/{id}")
    public String readEssay(@PathVariable Long id, Model model, @AuthUser Member member) {
        EssayDetail essay = essayService.getEssay(id);
        if (member != null) {
            boolean confirmLike = member.getLikeEssayList().stream().anyMatch((likeEssay) -> likeEssay.getId().equals(id));
            model.addAttribute("userInfo", member);
            model.addAttribute("confirmLike", confirmLike);
        }
        model.addAttribute("essay", essay);
        return "essay/detail";
    }

    @GetMapping("/modifyForm/{id}")
    public String goModifyForm(@PathVariable Long id) {
        return "essay/modify";
    }

    @PostMapping("/modify/{id}")
    public String modifyEssay(@PathVariable Long id, EssayForm essayForm, @AuthUser Guider guider) {
        essayService.modifyEssay(id, essayForm, guider);
        return "redirect:/essay/detail/" + id;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeEssay(@PathVariable Long id, @AuthUser Guider guider) {
        essayService.removeEssay(id, guider);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEssay(@PathVariable Long id) {
        EssayDetail essay = essayService.getEssay(id);
        return ResponseEntity.ok(essay);
    }

    @PutMapping("/{id}/like")
    public ResponseEntity<?> addLikeCount(@PathVariable Long id, @AuthUser Member member) {
        return ResponseEntity.ok(essayService.toggleLikeEssay(id, member));
    }

}
