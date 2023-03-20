package com.chase;

import com.chase.service.LoginService;
import com.chase.service.UserService;
import com.chase.service.UserServiceFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author chase
 * @date 2023/2/24 4:20 PM
 */
@SpringBootApplication
public class BootApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(BootApp.class, args);



        Object bean = applicationContext.getBean("userServiceFactoryBean");
        System.out.println("bean userServiceFactoryBean instanceof UserServiceFactoryBean:"+(bean instanceof UserServiceFactoryBean));
        System.out.println("bean userServiceFactoryBean instanceof UserService:"+(bean instanceof UserService));

        Object bean1 = applicationContext.getBean("&userServiceFactoryBean");
        System.out.println("&userServiceFactoryBean instanceof UserServiceFactoryBean:"+(bean1 instanceof UserServiceFactoryBean));
        System.out.println("&userServiceFactoryBean instanceof UserService:"+(bean1 instanceof UserService));

//        多例循环依赖，set注入失败
//        System.out.println(applicationContext.getBean(ServiceEEE.class));


    }

    @Bean
    public LoginService getLoginService(UserService userService) {
        return new LoginService(userService);
    }
}
