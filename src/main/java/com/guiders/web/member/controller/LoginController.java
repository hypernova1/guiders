package com.guiders.web.member.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.LoginService;
import com.guiders.web.util.NaverLoginBO;

@Controller
public class LoginController {
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;

	/* NaverLoginBO */
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO){
		this.naverLoginBO = naverLoginBO;
	}
  
  @Autowired
  private LoginService loginService;
  
  @GetMapping("/")
  public String main(Authentication authentication, HttpServletRequest req) {

    /*if (authentication != null) {
      UserCustom userCustom = (UserCustom) authentication.getPrincipal();
    }*/

    return "main/main";
  }
  
  @GetMapping("join")
  public String join() {
    return "main/join";
  }
  
  @PostMapping("join")
  public ResponseEntity<Boolean> join(@RequestBody GuiderVO guiderVO) {
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
  public String login(HttpSession session, Model model) {
	  
	  String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
	  
	  model.addAttribute("url", naverAuthUrl);
	  
	  return "main/invalid_login";
  }
	@RequestMapping(value = "/callback")
	public ModelAndView naverCallback(
			HttpSession session, @RequestParam String code, @RequestParam String state) throws IOException {
		
		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		String apiResult = naverLoginBO.getUserProfile(oauthToken);
		
		session.setAttribute("naver", apiResult);
		
		return new ModelAndView("callback", "result", apiResult);

	}
  
}
