package org.brokers.guiders.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final RequestCache requestCache = new HttpSessionRequestCache();

    private final String targetUrlParameter = "loginRedirect";

    private final String defaultUrl = "/";

    private final boolean useReferer = false;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String targetUrl = savedRequest.getRedirectUrl();

        if (targetUrl == null) {
            targetUrl = defaultUrl;
        }

        String accept = request.getHeader("accept");

        if (StringUtils.indexOf(accept, "json") > -1) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            Map<String, Object> responseInfo = new HashMap<>();
            responseInfo.put("error", false);
            responseInfo.put("url", targetUrl);

            String json = new ObjectMapper().writeValueAsString(responseInfo);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        }

    }

    public String getTargetUrlParameter() {
        return targetUrlParameter;
    }

}
