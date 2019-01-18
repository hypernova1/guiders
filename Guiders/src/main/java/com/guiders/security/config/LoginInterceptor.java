package com.guiders.security.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.guiders.web.member.service.MemberService;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private MemberService memberService;
	
	private String email = null;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(email != null) {
			email = request.getParameter("email");
			System.out.println("email : " + email);
		}
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(email != null) {
			System.out.println("after...............: " + memberService.readMember(email).getEmail());
			session.setAttribute("memberEmail", email);
		}

		super.postHandle(request, response, handler, modelAndView);
	}

	
}
