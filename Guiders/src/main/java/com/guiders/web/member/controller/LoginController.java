package com.guiders.web.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.LoginService;

@Controller
public class LoginController {
  
  @Autowired
  private LoginService loginService;
  
  @GetMapping("join")
  public String join() {
    return "main/join";
  }
  
  @PostMapping("join")
  public ResponseEntity<Boolean> join(@RequestBody GuiderVO guiderVO) {
    System.out.println(guiderVO.getCurrentjob());
    loginService.join(guiderVO);
    return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    
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
