package com.guiders.web.member.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guiders.security.config.UserCustom;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@RequestMapping("mypage")
@Controller
public class MypageController {

  @Autowired
  private MemberService memberService;
  
  @GetMapping("myGuider")
  public String myGuiders() {
    return "mypage/myGuider";
  }
  
  @GetMapping("myGuiders")
  public @ResponseBody ResponseEntity<List<GuiderVO>> myGuiderList(Authentication authentication) {
    
    List<GuiderVO> list = null;
    if(authentication.isAuthenticated()) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      list = memberService.getMyGuider(user.getEmail());
    }
    return new ResponseEntity<>(list, HttpStatus.OK);
  }
  
  
  
}
