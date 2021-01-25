package org.brokers.guiders.web.essay;

import org.brokers.guiders.config.security.UserCustom;
import org.brokers.guiders.util.PageCriteria;
import org.brokers.guiders.util.Pagination;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public String writeEssay(Model model, Authentication authentication) {
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            Guider guider = (Guider) memberService.selectByEmail(user.getEmail(), "guider");
            model.addAttribute("email", guider.getEmail());

        }
        return "/essay/write";
    }

    @PostMapping("/write")
    public String writeEssay(Essay essay) {
        if (essay != null) {
            essayService.writeEssay(essay);
            return "redirect:/essay/list";
        }
        return "/essay/write"; // 글작성 실패
    }

    @GetMapping("/list")
    public String goEssayListPage(
            Model model,
            @Param("int") Integer page,
            PageCriteria cri) {

        if (page != null) {
            cri.setPage(page);
        }

        Pagination pm = new Pagination();
        pm.setCri(cri);
        pm.setTotal(essayService.getEssayCount(cri));

        List<Essay> list = essayService.getEssayList(cri);
        for (Essay essay : list) {
            String econtent = essay.getContent();
            econtent = econtent.replaceAll("<[^>]*>", "");
            econtent = econtent.replaceAll("&nbsp;", " ");
            econtent = econtent.replaceAll("&lt;", "<");
            econtent = econtent.replaceAll("&gt;", ">");
            econtent = econtent.replaceAll("&amp;", "&");
            essay.setContent(econtent);
        }

        model.addAttribute("essayList", list);
        model.addAttribute("pm", pm);
        return "/essay/list";
    }

    @GetMapping("/read")
    public String readEssay(@Param("eno") Long eno, Model model, Authentication authentication) {
        Map<String, String> map = new HashMap<>();
        if (authentication != null) {
            UserCustom userCustom = (UserCustom) authentication.getPrincipal();
            model.addAttribute("userInfo", userCustom);
            map.put("email", userCustom.getEmail());
        }
        Essay essay = essayService.readEssay(eno);
        map.put("eno", eno.toString());
        boolean confirmLike = essay.getLikeCount() == 1;
        model.addAttribute("essayVO", essay);
        model.addAttribute("confirmLike", confirmLike);
        return "/essay/post";
    }

    @GetMapping("/modify")
    public String modifyEssay(@Param("eno") Long eno, Model model) {

        Essay essay = essayService.readEssay(eno);
        model.addAttribute("essayVO", essay);

        return "/essay/modify";
    }

    @PostMapping("/modify")
    public String modifyEssay(Essay essay, @Param("eno") String eno) {
        if (essay != null) {
            essayService.modifyEssay(essay);
        }

        return "redirect:/essay/read?eno=" + eno;
    }

    @PostMapping("/delete")
    public String removeEssay(Long eno) {
        essayService.removeEssay(eno);
        return "redirect:/essay/list";
    }

    @PutMapping("/{eno}")
    @ResponseBody
    public ResponseEntity<Integer> addLikecnt(@RequestBody Map<String, String> map) {
        return ResponseEntity.ok(essayService.addRecommend(map)); // 갱신된 '좋아요' 갯수를 전달
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Essay>> getEssays() {
        return ResponseEntity.ok(essayService.getTopEssay());
    }

}
