package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.config.security.UserCustom;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.essay.EssayService;
import org.brokers.guiders.web.mentoring.Mentoring;
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
    private final MemberService memberService;

    @GetMapping("/likeEssay")
    public String likeEssay(@AuthUser Member member, Model model) {
        if (member != null) {
            List<Essay> likeEssayList = member.getLikeEssay();
            model.addAttribute("essayList", likeEssayList);
        }
        return "mypage/likeEssay";
    }

    @GetMapping("/myGuider")
    public String myGuiders() {
        return "mypage/myGuider";
    }

    @GetMapping("myGuiders")
    @ResponseBody
    public ResponseEntity<List<Guider>> myGuiderList(@AuthUser Member member) {
        List<Guider> followList = new ArrayList<>();
        if (member != null) {
            followList = ((Follower) member).getFollowList();
        }
        return ResponseEntity.ok(followList);
    }

    @GetMapping("/likeEssay/{id}")
    @ResponseBody
    public ResponseEntity<?> getEssay(@PathVariable("id") Long id) {
        String content = essayService.getEssay(id).getContent();
        return ResponseEntity.ok(content);
    }

    @GetMapping("/guider/{email}")
    @ResponseBody
    public ResponseEntity<Guider> guider(@PathVariable String email) {
        return ResponseEntity.ok((Guider) memberService.findByEmail(email));
    }

    @GetMapping("/questions")
    public String questions(@AuthUser Member member, Model model) {
        List<Mentoring> mentoringList = null;
        if (member != null) {
            mentoringList = ((Guider) member).getMentoringList();
        }
        model.addAttribute("mentoringList", mentoringList);
        return "mypage/questions";
    }

    @GetMapping("/edit")
    public String edit(Model model, @AuthUser Member member) {
        if (member != null) {
            Guider vo = (Guider) memberService.getInfo(member);
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
