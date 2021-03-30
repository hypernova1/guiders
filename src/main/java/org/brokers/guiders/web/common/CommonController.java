package org.brokers.guiders.web.common;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.util.UploadFileUtils;
import org.brokers.guiders.web.essay.payload.EssaySummary;
import org.brokers.guiders.web.essay.EssayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommonController {

    private final ServletContext servletContext;
    private final EssayService essayService;

    @GetMapping("/")
    public String main(Model model) {
        List<EssaySummary> topEssay = essayService.getTopEssay();
        model.addAttribute("topEssayList", topEssay);
        return "main";
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(MultipartFile file) throws Exception {

        String uploadPath = servletContext.getRealPath("/resources/img/photoUpload");
        /*String fixPath = uploadPath.replaceAll("\\\\", "/");*/
        String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());

        return "/resources/img/photoUpload" + fileName;

    }

}
