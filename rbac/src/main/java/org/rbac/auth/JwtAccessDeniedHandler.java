package org.rbac.auth;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chase
 * @date 2022/11/4 12:00 PM
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        try {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
