package com.guiders.web.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.guiders.web.member.domain.GuiderVO;

@Controller
public class LoginController {
  
  @GetMapping("join")
  public String join() {
    return "main/join";
  }
  
  @PostMapping("join")
  public String join(GuiderVO guiderVO) {
    
    return "redirect:/";
    
  }
  @GetMapping("joinform")
  public ModelAndView joinForm(boolean guider) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("guider", guider);
    mav.setViewName("main/joinForm");
    return mav;
  }
  
  @GetMapping("/login")
  public String login() {
	  return "main/invalid_login";
  }
  
}
