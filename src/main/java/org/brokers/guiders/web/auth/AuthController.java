package org.brokers.guiders.web.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequiredArgsConstructor
public class AuthController {

//    private final NaverLoginBO naverLoginBO;
    private final AuthService authService;

    @GetMapping("/join")
    public String join() {
        return "auth/join";
    }

    @GetMapping("/joinForm")
    public String joinForm(String type, Model model) {
        model.addAttribute("type", type);
        return "auth/joinForm";
    }

    @PostMapping("/join/guider")
    public ResponseEntity<?> joinGuider(@Valid @RequestBody AuthDto.GuiderJoinRequest joinDto) {
        Long id = authService.joinGuider(joinDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/user/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/join/follower")
    public ResponseEntity<?> joinFollower(@Valid @RequestBody AuthDto.FollowerJoinRequest joinDto) {
        Long id = authService.joinFollower(joinDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/user/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody AuthDto.LoginRequest loginDto) {
        authService.login(loginDto);
//        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//        model.addAttribute("url", naverAuthUrl);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

//    @GetMapping("/callback")
//    public ModelAndView naverCallback(
//            HttpSession session, @RequestParam String code, @RequestParam String state) throws IOException {
//        OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
//        String apiResult = naverLoginBO.getUserProfile(oauthToken);
//        session.setAttribute("naver", apiResult);
//        return new ModelAndView("/callback", "result", apiResult);
//    }

}
