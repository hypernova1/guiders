package com.guiders.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String main() {
    /*
     * 접속한 사람의 IP 주소 Object principal =
     * SecurityContextHolder.getContext().getAuthentication().getDetails(); if (authentication !=
     * null) { UserCustom userCustom = (UserCustom) authentication.getPrincipal(); }
     */
    return "main/main";
  }

}
