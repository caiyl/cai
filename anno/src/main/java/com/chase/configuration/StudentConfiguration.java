package com.chase.configuration;

import com.chase.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chase
 * @date 2023/3/6 4:56 PM
 */
@Configuration
public class StudentConfiguration {

    @Bean
    public StudentService getStudentService(){
        return new StudentService();
    }
}
