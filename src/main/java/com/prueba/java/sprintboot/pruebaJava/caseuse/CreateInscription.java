package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.entity.Inscription;
import com.prueba.java.sprintboot.pruebaJava.service.InscriptionService;
import org.springframework.stereotype.Component;

@Component
public class CreateInscription {
    private InscriptionService inscriptionService;

    public CreateInscription(InscriptionService inscriptionService){
        this.inscriptionService = inscriptionService;
    }

    public Inscription save(Inscription newInscription) {
        return inscriptionService.save(newInscription);
    }
}
