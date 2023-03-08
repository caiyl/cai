package org.hello.configuration;

import org.hello.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chase
 * @date 2023/3/8 3:53 PM
 */
@Configuration
public class HelloConfiguration {

    @Bean
    public HelloService getHelloService(){
        return new HelloService();
    }
}
