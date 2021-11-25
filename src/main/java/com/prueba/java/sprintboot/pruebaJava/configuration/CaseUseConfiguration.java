package com.prueba.java.sprintboot.pruebaJava.configuration;

import com.prueba.java.sprintboot.pruebaJava.caseuse.GetUser;
import com.prueba.java.sprintboot.pruebaJava.caseuse.GetUserImplement;
import com.prueba.java.sprintboot.pruebaJava.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {


    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
