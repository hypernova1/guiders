package org.brokers.guiders.config.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final String DEFAULT_TARGET_PARAMETER = "spring-security-redirect-login-failure";
    private final static String targetUrlParameter = DEFAULT_TARGET_PARAMETER;
    private final String defaultFailureUrl = "/signin?error=true";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        String accept = request.getHeader("accept");
        String error = "true";
        String message = "로그인실패하였습니다.";
        if (StringUtils.indexOf(accept, "html") > -1) {
            String redirectUrl = request.getParameter(targetUrlParameter);
            if (redirectUrl != null) {
                /*super.logger.debug("Found redirect URL: " + redirectUrl);*/
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                super.onAuthenticationFailure(request, response, exception);
            }
        } else if (StringUtils.indexOf(accept, "xml") > -1) {
            response.setContentType("application/xml");
            response.setCharacterEncoding("utf-8");
            String data = StringUtils.join("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "<response>",
                    "<error>", error, "</error>", "<message>", message, "</message>", "</response>");
            PrintWriter out = response.getWriter();
            out.print(data);
            out.flush();
            out.close();
        } else if (StringUtils.indexOf(accept, "json") > -1) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            String data = StringUtils.join(" { \"response\" : {", " \"error\" : ", error, ", ",
                    " \"message\" : \"", message, "\" ", "} } ");
            PrintWriter out = response.getWriter();
            out.print(data);
            out.flush();
            out.close();
        }
    }

    public String getTargetUrlParameter() {
        return targetUrlParameter;
    }

}
