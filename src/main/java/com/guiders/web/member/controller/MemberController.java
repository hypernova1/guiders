package com.guiders.web.member.controller;

import com.guiders.security.config.UserCustom;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;
import com.guiders.web.util.UploadFileUtils;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/guider")
    @ResponseBody
    public ResponseEntity<GuiderVO> getGuiderInfo(String email) {
        GuiderVO guider = memberService.selectByEmail(email, "guider");

        return new ResponseEntity<>(guider, HttpStatus.OK);
    }

    @GetMapping("/guider/list/{page}")
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> getGuiderList(
            @PathVariable Integer page, Authentication authentication) {
        List<Map<String, Object>> guiderList = null;
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            guiderList = memberService.getGuiderList(page, user.getEmail());
        } else {
            guiderList = memberService.getGuiderList(page, null);
        }
        return new ResponseEntity<>(guiderList, HttpStatus.OK);
    }

    @PostMapping("/follow")
    @ResponseBody
    public ResponseEntity<Boolean> follow(@RequestBody String guider, Authentication authentication) {
        Boolean result = false;
        JSONObject obj = new JSONObject(guider);
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            memberService.follow(obj.getString("guider"), user.getEmail());
            result = true;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/follow")
    @ResponseBody
    public ResponseEntity<Boolean> unfollow(@RequestBody String guider, Authentication authentication) {
        JSONObject obj = new JSONObject(guider);
        if (authentication.getPrincipal() != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            memberService.unfollow(obj.getString("guider"), user.getEmail());
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
