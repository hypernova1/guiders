package com.guiders.web.member.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.guiders.security.config.UserCustom;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@Controller
public class MemberController {

  @Autowired
  private MemberService memberService;

  @GetMapping("/mypage/edit")
  public String edit(Model model, HttpSession session, Authentication authentication) {
    if (authentication.getPrincipal() != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      GuiderVO vo = memberService.selectByEmail(user.getEmail());
      model.addAttribute("vo", vo);

    }

    return "mypage/edit";
  }

  @PostMapping("/mypage/edit")
  public String edit(GuiderVO vo, Authentication authentication) {
    if (vo != null && authentication.getPrincipal() != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      vo.setPassword(vo.getPassword().trim());
      System.out.println(vo.getPassword().equals(""));
      vo.setEmail(user.getEmail());
      
      memberService.modifyMember(vo);
    }
    return "redirect:/mypage/edit";
  }

}
