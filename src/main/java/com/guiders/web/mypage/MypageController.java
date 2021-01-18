package com.guiders.web.mypage;

import java.util.List;
import java.util.Map;

import com.guiders.web.member.GuiderVO;
import com.guiders.web.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.guiders.security.config.UserCustom;
import com.guiders.web.essay.EssayVO;
import com.guiders.web.mentoring.MentoringService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final MyPageService myPageService;
    private final MentoringService mentoringService;
    private final MemberService memberService;

    @GetMapping("/likeEssay")
    public String likeEssay(Authentication authentication, Model model) {
        List<EssayVO> list = null;
        if (authentication.isAuthenticated()) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            list = myPageService.getMyLikeEssay(user.getEmail());
            model.addAttribute("essayList", list);
        }
        return "mypage/likeEssay";
    }

    @GetMapping("/myGuider")
    public String myGuiders() {
        return "mypage/myGuider";
    }

    @GetMapping("myGuiders")
    public @ResponseBody
    ResponseEntity<List<Map<String, Object>>> myGuiderList(Authentication authentication) {
        List<Map<String, Object>> list = null;
        if (authentication.isAuthenticated()) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            list = myPageService.getMyGuiderList(user.getEmail());
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/likeEssay/{eno}")
    @ResponseBody
    public String getEssay(@PathVariable("eno") String eno) {
        return myPageService.getEssayContent(Integer.parseInt(eno));
    }

    @GetMapping("/guider/{email}")
    public @ResponseBody
    ResponseEntity<GuiderVO> guider(@PathVariable String email) {

        return new ResponseEntity<>(memberService.selectByEmail(email, "guider"), HttpStatus.OK);
    }

    @GetMapping("/questions")
    public String questions(Authentication authentication, Model model) {
        List<Map<String, Object>> mentorings = null;
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            mentorings = mentoringService.getMyQuestions(user.getEmail());
        }
        model.addAttribute("mentorings", mentorings);
        return "mypage/questions";
    }

    @GetMapping("/edit")
    public String edit(Model model, HttpSession session, Authentication authentication) {
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            String type = "guider";
            if (user.getAuthorities().toString().equals("[ROLE_MEMBER]")) {
                type = "member";
            }
            GuiderVO vo = memberService.selectByEmail(user.getEmail(), type);
            model.addAttribute("vo", vo);
        }

        return "mypage/edit";
    }

    @PostMapping("/edit")
    public String edit(GuiderVO vo, Authentication authentication) {
        if (vo != null && authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            vo.setPassword(vo.getPassword().trim());
            vo.setEmail(user.getEmail());

            memberService.modifyMember(vo);
        }
        return "redirect:/mypage/edit";
    }

}
