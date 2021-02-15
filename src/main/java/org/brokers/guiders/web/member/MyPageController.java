package org.brokers.guiders.web.member;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.essay.Essay;
import org.brokers.guiders.web.essay.EssayDto;
import org.brokers.guiders.web.member.guider.Guider;
import org.brokers.guiders.web.member.guider.GuiderService;
import org.brokers.guiders.web.mentoring.MentoringDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final MemberService memberService;
    private final GuiderService guiderService;
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

    @GetMapping("/edit")
    public String edit(Model model, @AuthUser Member member) {
        MemberDto.Update dto = memberService.getInfo(member);
        model.addAttribute("member", dto);
        return "mypage/edit";
    }

    @PostMapping("/edit")
    public String edit(MemberDto.Update memberDto, @AuthUser Member member) {
        memberService.modifyMember(memberDto, member);
        return "mypage/edit";
    }

    @GetMapping("/myGuider")
    public String myGuiders() {
        return "mypage/myGuider";
    }

    @GetMapping("/guiders")
    public String guiders() {
        return "/guiders/guiders";
    }

    @GetMapping("/questions")
    public String questions(@AuthUser Member member, Model model) {
        List<MentoringDto.Response> mentoringList = guiderService.getMentoringList((Guider) member);
        model.addAttribute("mentoringList", mentoringList);
        return "mypage/questions";
    }

}
