package com.guiders.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Principal prin) {
		if(prin != null) {
			String name = prin.getName();
			System.out.println("............." + name);	
		}
		return "main/main";
	}

	@GetMapping("/essay/list")
	public String essayList() {
		return "essay/list";
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
