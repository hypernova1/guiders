package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/essay")
@RequiredArgsConstructor
public class EssayController {

    private final EssayService essayService;

    @GetMapping("/write")
    public String writeEssay() {
        return "/essay/write";
    }

    @PostMapping("/write")
    public String writeEssay(EssayDto.Request request, @AuthUser Member member) {
        Long id = essayService.writeEssay(request, member);
        return "redirect:/essay/" + id;
    }

    @GetMapping("/list")
    public String goEssayListPage(Model model,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "") String keyword) {
        Page<EssayDto.Response> essayPage = essayService.getEssayList(page - 1, keyword);
        model.addAttribute("essayPage", essayPage);
        return "/essay/list";
    }

    @GetMapping("/{id}")
    public String readEssay(@PathVariable Long id, Model model, @AuthUser Member member) {
        EssayDto.DetailResponse essay = essayService.getEssay(id);
        if (member != null) {
            boolean confirmLike = member.isMyLikeEssay(essay.getId());
            model.addAttribute("userInfo", member);
            model.addAttribute("confirmLike", confirmLike);
        }
        model.addAttribute("essay", essay);
        return "/essay/post";
    }

    @GetMapping("/modify")
    public String modifyEssay(Long id, Model model) {
        EssayDto.DetailResponse essay = essayService.getEssay(id);
        model.addAttribute("essay", essay);
        return "/essay/modify";
    }

    @PostMapping("/modify/{id}")
    public String modifyEssay(@PathVariable Long id, EssayDto.Request request, @AuthUser Member member) {
        essayService.modifyEssay(id, request, member);
        return "redirect:/essay/" + id;
    }

    @GetMapping("/delete/{id}")
    public String removeEssay(@PathVariable Long id, @AuthUser Member member) {
        essayService.removeEssay(id, member);
        return "redirect:/essay/list";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEssay(@PathVariable Long id) {
        EssayDto.DetailResponse essay = essayService.getEssay(id);
        return ResponseEntity.ok(essay);
    }

    @PutMapping("/{id}/like")
    public ResponseEntity<?> addLikeCount(@PathVariable Long id, @AuthUser Member member) {
        return ResponseEntity.ok(essayService.toggleLikeEssay(id, member)); // 갱신된 '좋아요' 갯수를 전달
    }

    @GetMapping("/top6")
    public ResponseEntity<?> getEssays() {
        return ResponseEntity.ok(essayService.getTopEssay());
    }

}
