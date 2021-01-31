package org.brokers.guiders.web.auth;


import com.github.scribejava.core.model.OAuth2AccessToken;
import org.brokers.guiders.util.NaverLoginBO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;

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
    public ModelAndView joinForm(String type) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("type", type);
        mav.setViewName("main/joinForm");
        return mav;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AuthDto.LoginRequest loginDto) {
        authService.login(loginDto);
//        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//        model.addAttribute("url", naverAuthUrl);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/login")
    public String login() {
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
    public ResponseEntity<Boolean> join(@RequestBody AuthDto.JoinRequest joinDto) {
        Long id = authService.join(joinDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/user/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
