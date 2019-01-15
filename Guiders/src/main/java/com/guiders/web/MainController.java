package com.guiders.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String main() {
    return "main/main";
  }
  
  @GetMapping("/mypage/edit")
  public String edit() {
    return "mypage/edit";
  }
  
  @GetMapping("/essay/list")
  public String essayList() {
    return "essay/list";
  }
  
  @GetMapping("/essay/post")
  public String post() {
    return "essay/post";
  }
  
  @GetMapping("/join")
  public String join() {
    return "main/join";
  }
  
  @GetMapping("/joinform")
  public String joinForm() {
    return "main/joinForm";
  }
  
  @GetMapping("/guiders")
  public String guiders() {
    return "guiders/guiders";
  }
  
  @GetMapping("/mypage/likeEssay")
  public String likeEssay() {
    return "mypage/likeEssay";
  }
  
  @GetMapping("/mypage/myGuider")
  public String myGuider(){
	  
	  return "mypage/myGuider";
  }
}
