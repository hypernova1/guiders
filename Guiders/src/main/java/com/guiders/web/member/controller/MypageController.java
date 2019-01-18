package com.guiders.web.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("mypage")
@Controller
public class MypageController {

	@GetMapping("myGuider")
	public String myGuiders() {
		return "mypage/myGuider";
	}
}
