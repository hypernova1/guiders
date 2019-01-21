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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guiders.security.config.UserCustom;
import com.guiders.web.essay.domain.EssayVO;
import com.guiders.web.member.service.MyPageService;

@RequestMapping("mypage")
@Controller
public class MypageController {

  @Autowired
  private MyPageService myPageService;
  
  @GetMapping("likeEssay")
  public String likeEssay(Authentication authentication, Model model) {
	  List<EssayVO> list = null;
	  if(authentication.isAuthenticated()) {
		  UserCustom user = (UserCustom)authentication.getPrincipal();
		  list = myPageService.getMyLikeEssay(user.getEmail());
		  model.addAttribute("essayList", list);
	  }
	  return "mypage/likeEssay";
  }
  
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
  
  @RequestMapping(value="likeEssay/{eno}" , method=RequestMethod.GET , 
		          produces="application/json;charset=utf-8")
  public @ResponseBody String getEssay(@PathVariable("eno") String eno) {
	  String econtent = myPageService.getEssayContent(Integer.parseInt(eno));
	  return econtent;
  }
  
}
