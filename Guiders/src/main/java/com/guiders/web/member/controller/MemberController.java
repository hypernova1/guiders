package com.guiders.web.member.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/mypage/edit")
	public String edit(Model model, HttpSession session, Principal prin) {
		String name = prin.getName();
		GuiderVO vo = memberService.selectByName(name);
		model.addAttribute("vo", vo);
		
		return "mypage/edit";
	}
	
	@PostMapping("/mypage/edit")
	public String edit(GuiderVO vo) {
		System.out.println("vo : " + vo.getEmail());
		
		if(vo != null) {
			memberService.modifyMember(vo);
		}
		return "redirect:/mypage/edit";
	}
	
}
