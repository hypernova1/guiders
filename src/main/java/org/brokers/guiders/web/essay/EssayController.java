package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.util.PageCriteria;
import org.brokers.guiders.util.Pagination;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/essay")
@RequiredArgsConstructor
public class EssayController {

    private final EssayService essayService;
    private final MemberService memberService;

    @GetMapping("/write")
    public String writeEssay(Model model, @AuthUser Member member) {
        if (member != null) {
            Guider guider = (Guider) memberService.getInfo(member);
            model.addAttribute("email", guider.getEmail());
        }
        return "/essay/write";
    }

    @PostMapping("/write")
    public String writeEssay(EssayDto.Request request, @AuthUser Member member) {
        Long id = essayService.writeEssay(request, member);
        return "redirect:/essay/" + id;
    }

    @GetMapping("/list")
    public String goEssayListPage(Model model, @RequestParam(defaultValue = "1") Integer page, PageCriteria cri) {
        if (page != null) {
            cri.setPage(page);
        }
        Pagination pm = new Pagination();
        pm.setCri(cri);
        pm.setTotal(essayService.getEssayCount(cri));

        List<EssayDto.Response> list = essayService.getEssayList(cri);

        model.addAttribute("essayList", list);
        model.addAttribute("pm", pm);
        return "/essay/list";
    }

    @GetMapping("/{id}")
    public String readEssay(@PathVariable Long id, Model model, @AuthUser Member member) {
        Map<String, String> map = new HashMap<>();
        if (member != null) {
            model.addAttribute("userInfo", member);
            map.put("email", member.getEmail());
        }
        Essay essay = essayService.getEssay(id);
        map.put("id", id.toString());
        boolean confirmLike = essay.getLikeCount() == 1;
        model.addAttribute("essayVO", essay);
        model.addAttribute("confirmLike", confirmLike);
        return "/essay/post";
    }

    @GetMapping("/modify")
    public String modifyEssay(Long id, Model model) {
        Essay essay = essayService.getEssay(id);
        model.addAttribute("essayVO", essay);
        return "/essay/modify";
    }

    @PostMapping("/modify/{id}")
    public String modifyEssay(@PathVariable Long id, EssayDto.Request request) {
        essayService.modifyEssay(id, request);

        return "redirect:/essay/" + id;
    }

    @PostMapping("/delete")
    public String removeEssay(Long id) {
        essayService.removeEssay(id);
        return "redirect:/essay/list";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Integer> addLikeCount(@PathVariable Long id, @AuthUser Member member) {
        return ResponseEntity.ok(essayService.toggleLikeEssay(id, member)); // 갱신된 '좋아요' 갯수를 전달
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Essay>> getEssays() {
        return ResponseEntity.ok(essayService.getTopEssay());
    }

}
