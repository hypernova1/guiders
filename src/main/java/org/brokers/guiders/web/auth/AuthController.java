package org.brokers.guiders.web.auth;


import com.github.scribejava.core.model.OAuth2AccessToken;
import org.brokers.guiders.util.NaverLoginBO;
import org.brokers.guiders.web.member.Guider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final NaverLoginBO naverLoginBO;
    private final AuthService authService;

    @GetMapping("join")
    public String join() {
        return "main/join";
    }

    @GetMapping("/joinform")
    public ModelAndView joinForm(boolean guider) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("guider", guider);
        mav.setViewName("main/joinForm");
        return mav;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        authService.login(loginDto);
//        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//        model.addAttribute("url", naverAuthUrl);
        return "main/invalid_login";
    }

    @GetMapping("/callback")
    public ModelAndView naverCallback(
            HttpSession session, @RequestParam String code, @RequestParam String state) throws IOException {
        OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
        String apiResult = naverLoginBO.getUserProfile(oauthToken);
        session.setAttribute("naver", apiResult);
        return new ModelAndView("callback", "result", apiResult);
    }

    @PostMapping("join")
    @ResponseBody
    public ResponseEntity<Boolean> join(@RequestBody Guider guider) {
        authService.join(guider);
        return ResponseEntity.ok(true);
    }

}
