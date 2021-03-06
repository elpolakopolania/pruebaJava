package com.prueba.java.sprintboot.pruebaJava.configuration;

import com.prueba.java.sprintboot.pruebaJava.caseuse.*;
import com.prueba.java.sprintboot.pruebaJava.service.HouseService;
import com.prueba.java.sprintboot.pruebaJava.service.InscriptionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetInscription getInscription(InscriptionService inscriptionService){
        return new GetInscriptionImplement(inscriptionService);
    }

    @Bean
    GetHouse getHouse(HouseService houseService){
        return new GetHouseImplement(houseService);
    }
}
