package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chase
 * @date 2023/3/13 5:12 PM
 */

@Component
public class AnnotationPropertiesBean {

    @Value("${loginUrl}")
    private String loginUrl;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
