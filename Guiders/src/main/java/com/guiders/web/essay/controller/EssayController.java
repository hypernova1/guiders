package com.guiders.web.essay.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guiders.security.config.UserCustom;
import com.guiders.web.essay.domain.EssayVO;
import com.guiders.web.essay.service.EssayService;
import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@Controller
public class EssayController {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private EssayService essayService;

	@Autowired
	private MemberService memberService;

	@GetMapping("/essay/write")
	public String writeEssay(Model model, Principal prin) {
		if (prin != null) {
			String name = prin.getName();
			GuiderVO vo = memberService.selectByName(name);
			model.addAttribute("email", vo.getEmail());
		}
		return "/essay/write";
	}

	@PostMapping("/essay/write")
	public String writeEssay(EssayVO essayVO) {
		if (essayVO != null) {
			essayService.writeEssay(essayVO);
			return "redirect:/essay/list";
		} else {
			return "/essay/write"; // 글작성 실패
		}
	}
	
	@GetMapping("/essay/list")
	public String essayList(Model model) { //페이징 관련 parameter 받을 예정
		List<EssayVO> list = essayService.essayList();
		for(int i = 0; i < list.size(); i ++) {
			String econtent = list.get(i).getEcontent();
			econtent = econtent.replaceAll("<[^>]*>","");
			econtent = econtent.replaceAll("&nbsp;"," ");
			econtent = econtent.replaceAll("&lt;","<");
			econtent = econtent.replaceAll("&gt;",">");
			econtent = econtent.replaceAll("&amp;","&");
			list.get(i).setEcontent(econtent);
		}
		
		model.addAttribute("essayList", list);
		
		return "/essay/list";
	}

	@GetMapping("/essay/read")
	public String readEssay(@Param("eno") Integer eno, Model model, Authentication authentication){
		if (authentication != null) {
			UserCustom userCustom = (UserCustom) authentication.getPrincipal();
			model.addAttribute("userInfo", userCustom);
		}
		
		EssayVO essayVO = essayService.readEssay(eno);
		model.addAttribute("essayVO", essayVO);
		return "/essay/post";
	}
	
	@GetMapping("/essay/modify")
	public String modifyEssay(@Param("eno") Integer eno, Model model) {
		
		EssayVO essayVO = essayService.readEssay(eno);
		model.addAttribute("essayVO", essayVO);
		
		return "/essay/modify";
	}
	
	@PostMapping("/essay/modify")
	public String modifyEssay(EssayVO essayVO, @Param("eno") String eno) {
		if(essayVO != null) {
			essayService.modifyEssay(essayVO);
		}
		
		return "redirect:/essay/read?eno=" + eno;
	}

	// 다중파일업로드
	@RequestMapping(value = "/file_uploader_html5.do", method = RequestMethod.POST)
	@ResponseBody
	public String multiplePhotoUpload(HttpServletRequest request) {
		// 파일정보
		StringBuffer sb = new StringBuffer();
		try {
			// 일반 원본파일명
			String oldName = request.getHeader("file-name");
			// 파일 기본경로 _ 상세경로

			/* 배포시 실제로 저장될 경로를 지정 */
			String filePath = servletContext.getRealPath("/resources/img/photoUpload/");

			String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis()))
					.append(UUID.randomUUID().toString()).append(oldName.substring(oldName.lastIndexOf(".")))
					.toString();
			InputStream is = request.getInputStream();
			OutputStream os = new FileOutputStream(filePath + saveName);
			int numRead;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			while ((numRead = is.read(b, 0, b.length)) != -1) {
				os.write(b, 0, numRead);
			}
			os.flush();
			os.close();
			// 정보 출력
			sb = new StringBuffer();
			sb.append("&bNewLine=true").append("&sFileName=").append(oldName).append("&sFileURL=")
					.append("http://localhost:8888/img/photoUpload/").append(saveName); //IP를 서버쪽으로
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
