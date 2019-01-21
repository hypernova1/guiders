package com.guiders.web.guiders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.guiders.security.config.UserCustom;
import com.guiders.web.guiders.domain.MentoringVO;
import com.guiders.web.guiders.service.MentoringService;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@Controller
public class MentoringController {
  
  @Autowired
  private MentoringService mentoringService;
  @Autowired
  private MemberService memberService;
  
  @PostMapping("mentoring")
  public ResponseEntity<Boolean> question(
      @RequestBody MentoringVO mentoringVO,
      Authentication authentication) {
    if(authentication != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      mentoringVO.setFollower(user.getEmail());
      mentoringService.question(mentoringVO);
    }
    
    return new ResponseEntity<>(true, HttpStatus.OK);
  }
  
  @PostMapping("mentoring/answer")
  public String answer(MentoringVO mentoringVO) {
    mentoringService.answer(mentoringVO);
    
    return "redirect:/qna/" + mentoringVO.getMtrno();
  }
  
  
  @GetMapping("qna/{mtrno}")
  public String qna(@PathVariable Integer mtrno, Model model) {
    MentoringVO mentoringVO = mentoringService.getMentoring(mtrno);
    GuiderVO guiderVO = memberService.selectByEmail(mentoringVO.getGuider());
    model.addAttribute("mentoring", mentoringVO);
    model.addAttribute("guider", guiderVO);
    return "mypage/qna";
  }
}
