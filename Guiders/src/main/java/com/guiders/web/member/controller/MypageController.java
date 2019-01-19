package com.guiders.web.member.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.guiders.web.member.domain.GuiderVO;

@RequestMapping("mypage")
@Controller
public class MypageController {

  @GetMapping("myGuider")
  public String myGuiders() {
    return "mypage/myGuider";
  }
  
  @GetMapping("myGuiders")
  public ResponseEntity<List<GuiderVO>> myGuiderList(){
    
    
    return new ResponseEntity<>(null, HttpStatus.OK);
  }
  
  
}
