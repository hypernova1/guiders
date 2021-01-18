package com.guiders.web;

import com.guiders.security.config.UserCustom;
import com.guiders.util.URLConn;
import com.guiders.util.UploadFileUtils;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CommonController {

    private final ServletContext servletContext;

    @GetMapping("/")
    public String main(Authentication authentication, HttpServletRequest req) {
        return "main/main";
    }

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

            /* 배포시 실제로 저장될 경로 지정 */
            String filePath = servletContext.getRealPath("/resources/img/photoUpload/");

            String saveName =
                    sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis()))
                            .append(UUID.randomUUID().toString())
                            .append(oldName.substring(oldName.lastIndexOf("."))).toString();
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
                    .append("/img/photoUpload/").append(saveName); // 서버쪽 주소를 기준으로...
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
    public @ResponseBody
    String uploadImage(MultipartFile file) throws Exception {

        String uploadPath = servletContext.getRealPath("/resources/img/photoUpload");
        /*String fixPath = uploadPath.replaceAll("\\\\", "/");*/
        String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
        String resultPath = "/img/photoUpload" + fileName;

        return resultPath;

    }

}
