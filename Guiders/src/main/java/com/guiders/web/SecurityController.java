package com.guiders.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

	@RequestMapping("/forGuest")
	public String doForGuest() {
		return "security/forGuest";
	}

	@RequestMapping("/forMember")
	public void doForMember() {
		
	}

	@RequestMapping("/forManager")
	public void doForManager() {
		
	}

	@RequestMapping("/forAdmin")
	public String doForAdmin() {
		return "security/forAdmin";
	}

	@RequestMapping("/login2")
	public @ResponseBody String loginTest() {
		System.out.println("....................");
		return "aaa";
	}
	
	@RequestMapping("/login")
	public String loginView() {
		return "security/signin";
	}
}
