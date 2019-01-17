package com.guiders.config.mybatis.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		String accept = request.getHeader("accept");
		/*String referer = (String) request.getHeader("referer");*/
		String loginRedirect = request.getParameter("loginRedirect");
		System.out.println("loginRedirect : " + loginRedirect);
		
		if (StringUtils.indexOf(accept, "json") > -1) {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			String data = StringUtils.join(new String[] { " { \"response\" : {", " \"error\" : false , ",
					" \"message\" : \"로그인하였습니다.\" ", "} } " });
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
		}
		
		
	}
}
