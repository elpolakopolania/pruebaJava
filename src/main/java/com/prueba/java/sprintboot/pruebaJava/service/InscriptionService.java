package com.prueba.java.sprintboot.pruebaJava.service;

import com.prueba.java.sprintboot.pruebaJava.entity.Inscription;
import com.prueba.java.sprintboot.pruebaJava.repository.InscriptionRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InscriptionService {
    private final Log LOG = LogFactory.getLog(InscriptionService.class);
    private InscriptionRepository inscriptionRepository;
    private InscriptionService inscriptionService;

    public InscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Transactional
    public void saveTransactional(List<Inscription> inscriptions){
        inscriptions.stream()
                .peek(inscription -> LOG.info("Usuario insertado desde transactional => " + inscription ))
                .forEach(inscriptionRepository::save);
    }

    public List<Inscription> getAllInscriptions(){
        return inscriptionRepository.findAll();
    }

    public Inscription save(Inscription newInscription) {
        return inscriptionRepository.save(newInscription);
    }

    public void delete(Long id) {
        inscriptionRepository.delete(new Inscription(id));
    }

    public Inscription update(Inscription newInscription, Long id) {
        return inscriptionRepository.findById(id)
                .map(
                        inscription -> {
                            inscription.setName(newInscription.getName());
                            inscription.setLastname(newInscription.getLastname());
                            inscription.setIdentification(newInscription.getIdentification());
                            inscription.setAge(newInscription.getAge());
                            inscription.setHouse(newInscription.getHouse());
                            return inscriptionRepository.save(inscription);
                        }
                ).get();
    }
}
