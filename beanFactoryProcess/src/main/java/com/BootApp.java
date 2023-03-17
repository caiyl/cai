package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * @author chase
 * @date 2023/2/24 4:20 PM
 */
@SpringBootApplication
@ImportResource(locations={"classpath:beans.xml"})
public class BootApp {
    public static void main(String[] args) {


        ApplicationContext applicationContext = SpringApplication.run(BootApp.class, args);

        System.out.println(applicationContext.getBean(XmlPropertiesBean.class).getLoginUrl());
        System.out.println(applicationContext.getBean(AnnotationPropertiesBean.class).getLoginUrl());
    }

    @Bean
    public HelloBeanFactoryPostProcess getHelloBeanFactoryProcess(){
        return new HelloBeanFactoryPostProcess();
    }

}
