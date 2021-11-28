package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.entity.Inscription;
import com.prueba.java.sprintboot.pruebaJava.service.InscriptionService;
import org.springframework.stereotype.Component;

@Component
public class UpdateInscription {
    private InscriptionService inscriptionService;

    public UpdateInscription(InscriptionService inscriptionService){
        this.inscriptionService = inscriptionService;
    }

    public Inscription update(Inscription newInscription, Long id) {
         return inscriptionService.update(newInscription, id);
    }
}
