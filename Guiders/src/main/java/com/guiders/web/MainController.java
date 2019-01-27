package com.guiders.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guiders.security.config.UserCustom;
import com.guiders.web.util.URLConn;

@Controller
public class MainController {

	@ResponseBody
	@RequestMapping(value = "/start", method = RequestMethod.POST, consumes = "application/json")
	public String startApp(@RequestBody String body) {
		System.out.println(body);
		return "/";
	}
    @RequestMapping(value = "/doA", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String doA(Locale locale, Model model, Authentication authentication, 
    		@RequestBody String etitle){
        JSONObject cred = new JSONObject();
        JSONObject auth=new JSONObject();
        JSONObject parent=new JSONObject();
		if (authentication != null) {
			UserCustom userCustom = (UserCustom) authentication.getPrincipal();
			String userName = userCustom.getUsername();
			cred.put("username",userName);
		}
        cred.put("etitle", etitle);
        System.out.println(etitle);
        auth.put("userInfo", cred);
        parent.put("auth", auth);

        URLConn conn = new URLConn("http://127.0.0.1", 1516);
        conn.urlPost(parent);

        return "/";
    }

}
