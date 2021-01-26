package org.brokers.guiders.web;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.UserCustom;
import org.brokers.guiders.util.URLConn;
import org.brokers.guiders.util.UploadFileUtils;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String main() {
        return "main/main";
    }

    @PostMapping("/doA")
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
        auth.put("userInfo", cred);
        parent.put("auth", auth);

        URLConn conn = new URLConn("http://127.0.0.1", 1516);
        conn.urlPost(parent);

        return "/";
    }

    // 다중파일업로드
    @PostMapping("/file_uploader_html5.do")
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
            byte[] b = new byte[Integer.parseInt(request.getHeader("file-size"))];
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

    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(MultipartFile file) throws Exception {

        String uploadPath = servletContext.getRealPath("/resources/img/photoUpload");
        /*String fixPath = uploadPath.replaceAll("\\\\", "/");*/
        String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());

        return "/img/photoUpload" + fileName;

    }

}
