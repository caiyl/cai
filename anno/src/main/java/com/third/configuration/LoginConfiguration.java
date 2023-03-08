package com.third.configuration;

import com.third.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chase
 * @date 2023/3/6 4:56 PM
 */
@Configuration
public class LoginConfiguration {

    @Bean
    public LoginService getLoginService(){
        return new LoginService();
    }
}
