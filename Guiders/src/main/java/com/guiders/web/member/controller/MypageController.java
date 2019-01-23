package com.guiders.web.member.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guiders.security.config.UserCustom;
import com.guiders.web.guiders.service.MentoringService;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;
import com.guiders.web.member.service.MyPageService;

@RequestMapping("mypage")
@Controller
public class MypageController {

  @Autowired
  private MyPageService myPageService;
  @Autowired
  private MentoringService mentoringService;
  @Autowired
  private MemberService memberService;
  
  @GetMapping("myGuider")
  public String myGuiders() {
    return "mypage/myGuider";
  }
  
  @GetMapping("myGuiders")
  public @ResponseBody ResponseEntity<List<Map<String, Object>>> myGuiderList(Authentication authentication) {
    List<Map<String, Object>> list = null;
    if(authentication.isAuthenticated()) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      list = myPageService.getMyGuiderList(user.getEmail());
    }
    return new ResponseEntity<>(list, HttpStatus.OK);
  }
  
  @GetMapping("guider/{email}")
  public @ResponseBody ResponseEntity<GuiderVO> guider(@PathVariable String email){
    
    return new ResponseEntity<>(memberService.selectByEmail(email, "guider"), HttpStatus.OK);
  }
  
  @GetMapping("questions")
  public String questions(Authentication authentication, Model model) {
    List<Map<String, Object>> mentorings = null;
    if(authentication != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      mentorings = mentoringService.getMyQuestions(user.getEmail());
    }
    model.addAttribute("mentorings", mentorings);
    return "mypage/questions";
  }
  
  
}
