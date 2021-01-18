package com.guiders.security.config;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final RequestCache requestCache = new HttpSessionRequestCache();

    private String targetUrlParameter;

    private String defaultUrl;

    public LoginSuccessHandler() {
        targetUrlParameter = "";
        defaultUrl = "/";
    }

    public String getTargetUrlParameter() {
        return targetUrlParameter;
    }

    public void setTargetUrlParameter(String targetUrlParameter) {
        this.targetUrlParameter = targetUrlParameter;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String targetUrl;

        if (savedRequest != null) {
            targetUrl = savedRequest.getRedirectUrl();
        } else {
            targetUrl = defaultUrl;
        }

        String accept = request.getHeader("accept");

        if (StringUtils.indexOf(accept, "json") > -1) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            JSONObject responseInfo = new JSONObject();
            responseInfo.put("error", false);
            responseInfo.put("url", targetUrl);

            PrintWriter out = response.getWriter();
            out.print(responseInfo);
            out.flush();
            out.close();
        }

    }

}
