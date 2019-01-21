package com.guiders.web.member.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guiders.security.config.UserCustom;
import com.guiders.web.member.service.MemberService;
import com.guiders.web.member.service.MyPageService;

@RequestMapping("mypage")
@Controller
public class MypageController {

  @Autowired
  private MyPageService myPageService;
  
  @GetMapping("myGuider")
  public String myGuiders() {
    return "mypage/myGuider";
  }
  
  @GetMapping("myGuiders")
  public @ResponseBody ResponseEntity<List<Map<String, String>>> myGuiderList(Authentication authentication) {
    List<Map<String, String>> list = null;
    if(authentication.isAuthenticated()) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      list = myPageService.getMyGuiderList(user.getEmail());
    }
    return new ResponseEntity<>(list, HttpStatus.OK);
  }
  
}
