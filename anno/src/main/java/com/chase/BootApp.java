package com.chase;


import com.chase.service.PersonService;
import com.chase.service.StudentService;
import com.third.configuration.LoginConfiguration;
import com.third.configuration.WeatherImportSelector;
import com.third.service.LoginService;
import com.third.service.WeatherService;
import org.hello.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author chase
 * @date 2023/2/24 4:20 PM
 */
@Import({PersonService.class, LoginConfiguration.class, WeatherImportSelector.class})
//@EnableHello
@SpringBootApplication
public class BootApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(BootApp.class, args);

        applicationContext.getBean(PersonService.class).sayHello();
        applicationContext.getBean(StudentService.class).sayHello();
        applicationContext.getBean(LoginService.class).sayHello();
        applicationContext.getBean(WeatherService.class).sayHello();
        applicationContext.getBean(HelloService.class).sayHello();

    }


}
