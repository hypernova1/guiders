package com.guiders.web.essay;

import com.guiders.security.config.UserCustom;
import com.guiders.util.PageCriteria;
import com.guiders.util.Pagination;
import com.guiders.web.member.GuiderVO;
import com.guiders.web.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/essay")
@RequiredArgsConstructor
public class EssayController {

    private final EssayService essayService;
    private final MemberService memberService;

    @GetMapping("/write")
    public String writeEssay(Model model, Authentication authentication) {
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            GuiderVO vo = memberService.selectByEmail(user.getEmail(), "guider");
            model.addAttribute("email", vo.getEmail());

        }
        return "/essay/write";
    }

    @PostMapping("/write")
    public String writeEssay(EssayVO essayVO) {
        if (essayVO != null) {
            essayService.writeEssay(essayVO);
            return "redirect:/essay/list";
        } else {
            return "/essay/write"; // 글작성 실패
        }
    }

    @GetMapping("/list")
    public String goEssayListPage(Model model, @Param("int") Integer page, PageCriteria cri) {
        if (page != null) {
            cri.setPage(page);
        }
        Pagination pm = new Pagination();
        pm.setCri(cri);
        pm.setTotal(essayService.getEssayCount(cri));

        Integer startNum = cri.getPageStart();
        List<EssayVO> list = essayService.getEssayList(startNum, cri);
        for (EssayVO essayVO : list) {
            String econtent = essayVO.getEcontent();
            econtent = econtent.replaceAll("<[^>]*>", "");
            econtent = econtent.replaceAll("&nbsp;", " ");
            econtent = econtent.replaceAll("&lt;", "<");
            econtent = econtent.replaceAll("&gt;", ">");
            econtent = econtent.replaceAll("&amp;", "&");
            essayVO.setEcontent(econtent);
        }

        model.addAttribute("essayList", list);
        model.addAttribute("pm", pm);
        return "/essay/list";
    }

    @GetMapping("/read")
    public String readEssay(@Param("eno") Integer eno, Model model, Authentication authentication) {
        Map<String, String> map = new HashMap<>();
        if (authentication != null) {
            UserCustom userCustom = (UserCustom) authentication.getPrincipal();
            model.addAttribute("userInfo", userCustom);
            map.put("email", userCustom.getEmail());
        }
        EssayVO essayVO = essayService.readEssay(eno);
        map.put("eno", eno.toString());
        boolean confirmLike = essayService.confirmLike(map);
        model.addAttribute("essayVO", essayVO);
        model.addAttribute("confirmLike", confirmLike);
        return "/essay/post";
    }

    @GetMapping("/modify")
    public String modifyEssay(@Param("eno") Integer eno, Model model) {

        EssayVO essayVO = essayService.readEssay(eno);
        model.addAttribute("essayVO", essayVO);

        return "/essay/modify";
    }

    @PostMapping("/modify")
    public String modifyEssay(EssayVO essayVO, @Param("eno") String eno) {
        if (essayVO != null) {
            essayService.modifyEssay(essayVO);
        }

        return "redirect:/essay/read?eno=" + eno;
    }

    @PostMapping("/delete")
    public String removeEssay(Integer eno) {
        essayService.removeEssay(eno);
        return "redirect:/essay/list";
    }

    @PutMapping("/{eno}")
    @ResponseBody
    public Integer addLikecnt(@RequestBody Map<String, String> map) {
        System.out.println(map.get("eno"));
        return essayService.addRecommend(map); // 갱신된 '좋아요' 갯수를 전달
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> getEssays() {
        return new ResponseEntity<>(essayService.getTopEssay(), HttpStatus.OK);
    }

}
