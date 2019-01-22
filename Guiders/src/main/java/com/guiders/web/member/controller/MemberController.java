package com.guiders.web.member.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guiders.config.mybatis.config.UploadFileUtils;
import com.guiders.security.config.UserCustom;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@Controller
@CrossOrigin(origins= "*")
public class MemberController {
	
  @Autowired
  private ServletContext servletContext;

  @Autowired
  private MemberService memberService;

  @GetMapping("/mypage/edit")
  public String edit(Model model, HttpSession session, Authentication authentication) {
    if (authentication.getPrincipal() != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      GuiderVO vo = memberService.selectByEmail(user.getEmail());
      model.addAttribute("vo", vo);

    }

    return "mypage/edit";
  }

  @PostMapping("/mypage/edit")
  public String edit(GuiderVO vo, Authentication authentication) {
    if (vo != null && authentication.getPrincipal() != null) {
      UserCustom user = (UserCustom) authentication.getPrincipal();
      vo.setPassword(vo.getPassword().trim());
      System.out.println(vo.getPassword().equals(""));
      vo.setEmail(user.getEmail());
      
      memberService.modifyMember(vo);
    }
    return "redirect:/mypage/edit";
  }
  
  @RequestMapping(value = "/uploadImage", method = RequestMethod.POST, produces="text/plain; charset=UTF-8")
  public @ResponseBody String uploadImage(MultipartFile file) throws Exception{
	  
	  String uploadPath = servletContext.getRealPath("/resources/img/photoUpload"); 
	  /*String fixPath = uploadPath.replaceAll("\\\\", "/");*/
	  String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
	  String resultPath = "http://localhost:8888/img/photoUpload" + fileName;
	  return resultPath;
	  
  }

}
