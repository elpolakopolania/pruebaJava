package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.service.InscriptionService;
import com.prueba.java.sprintboot.pruebaJava.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteInscription {
    private InscriptionService inscriptionService;

    public DeleteInscription(InscriptionService inscriptionService){
        this.inscriptionService = inscriptionService;
    }

    public void remove(Long id) {
        inscriptionService.delete(id);
    }
}
