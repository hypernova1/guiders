package com.guiders.web.essay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EssayController {
	
	@GetMapping("essay/write")
	public String writeEssay() {
		return "/essay/write";
	}
	
}
