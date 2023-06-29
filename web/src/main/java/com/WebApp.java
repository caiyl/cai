package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author chase
 * @date 2023/1/30 5:24 PM
 */
@SpringBootApplication
public class WebApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(WebApp.class, args);

    }
}
