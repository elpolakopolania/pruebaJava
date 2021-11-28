package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.entity.Inscription;
import com.prueba.java.sprintboot.pruebaJava.service.InscriptionService;

import java.util.List;

public class GetInscriptionImplement implements  GetInscription{
    private InscriptionService inscriptionService;

    public GetInscriptionImplement(InscriptionService inscriptionService){
        this.inscriptionService = inscriptionService;
    }

    @Override
    public List<Inscription> getAll() {
        return inscriptionService.getAllInscriptions();
    }
}
