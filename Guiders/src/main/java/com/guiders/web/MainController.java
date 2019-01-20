package com.guiders.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.guiders.security.config.UserCustom;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Authentication authentication) {
		/* 접속한 사람의 IP 주소
		 * Object principal =
		 * SecurityContextHolder.getContext().getAuthentication().getDetails();
		 */
		
		if (authentication != null) {
			UserCustom userCustom = (UserCustom) authentication.getPrincipal();
		}

		return "main/main";
	}


	@GetMapping("/essay/post")
	public String post() {
		return "essay/post";
	}

	/*
	 * @GetMapping("/join") public String join() { return "main/join"; }
	 * 
	 * @GetMapping("/joinform") public String joinForm() { return "main/joinForm"; }
	 */

	@GetMapping("/guiders")
	public String guiders() {
		return "guiders/guiders";
	}

	@GetMapping("/mypage/likeEssay")
	public String likeEssay() {
		return "mypage/likeEssay";
	}

	@GetMapping("/signin")
	public String login() {
		return "mypage/myGuider";
	}

}
