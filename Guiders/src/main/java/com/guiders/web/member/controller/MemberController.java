package com.guiders.web.member.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guiders.security.config.UserCustom;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@Controller
public class MemberController {

  @Autowired
  private MemberService memberService;

  @GetMapping("/mypage/edit")
  public String edit(Model model, HttpSession session, Authentication authentication) {
    if (authentication != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      String type = "guider";
      if(user.getAuthorities().toString().equals("[ROLE_MEMBER]")) {
        type = "member";
      }
      GuiderVO vo = memberService.selectByEmail(user.getEmail(), type);
      model.addAttribute("vo", vo);
    }

    return "mypage/edit";
  }

  @PostMapping("/mypage/edit")
  public String edit(GuiderVO vo, Authentication authentication) {
    if (vo != null && authentication != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      vo.setPassword(vo.getPassword().trim());
      vo.setEmail(user.getEmail());
      
      memberService.modifyMember(vo);
    }
    return "redirect:/mypage/edit";
  }
  
  @GetMapping("guider")
  public @ResponseBody ResponseEntity<GuiderVO> getGuiderInfo(String email){
    GuiderVO guider = memberService.selectByEmail(email, "guider");
    
    return new ResponseEntity<>(guider, HttpStatus.OK);
  }
  
  @GetMapping("guider/list/{page}")
  public @ResponseBody ResponseEntity<List<Map<String, Object>>> getGuiderList(
      @PathVariable Integer page, Authentication authentication){
    List<Map<String, Object>> guiderList = null;
    if(authentication != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      guiderList = memberService.getGuiderList(page, user.getEmail());
    } else {
      guiderList = memberService.getGuiderList(page, null);
    }
    return new ResponseEntity<>(guiderList, HttpStatus.OK);
  }
  
  @PostMapping("follow")
  public @ResponseBody ResponseEntity<Boolean> follow(@RequestBody String guider, Authentication authentication){
    Boolean result = false;
    JSONObject obj = new JSONObject(guider);
    if(authentication != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      memberService.follow(obj.getString("guider"), user.getEmail()); 
      result = true;
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
  
  @DeleteMapping("follow")
  public @ResponseBody ResponseEntity<Boolean> unfollow(@RequestBody String guider, Authentication authentication){
    JSONObject obj = new JSONObject(guider);
    if(authentication.getPrincipal() != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      memberService.unfollow(obj.getString("guider"), user.getEmail()); 
    }
    return new ResponseEntity<>(true, HttpStatus.OK);
  }
}
