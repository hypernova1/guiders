package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.essay.EssayDto;
import org.brokers.guiders.web.essay.EssayService;
import org.brokers.guiders.web.mentoring.Mentoring;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final EssayService essayService;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @GetMapping("/likeEssay")
    public String likeEssay(@AuthUser Member member, Model model) {
        List<Essay> likeEssayList = member.getLikeEssay();
        List<EssayDto.DetailResponse> dtoList = likeEssayList.stream()
                .map(essay -> modelMapper.map(essay, EssayDto.DetailResponse.class))
                .collect(Collectors.toList());
        model.addAttribute("essayList", dtoList);
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
        MemberDto.Update dto = memberService.getInfo(member);
        model.addAttribute("member", dto);
        return "mypage/edit";
    }

    @PostMapping("/edit")
    public String edit(MemberDto.Update memberDto, @AuthUser Member member) {
        memberService.modifyMember(memberDto, member);
        return "redirect:/mypage/edit";
    }

}
