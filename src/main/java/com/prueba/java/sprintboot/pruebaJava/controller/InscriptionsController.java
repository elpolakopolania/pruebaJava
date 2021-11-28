package com.prueba.java.sprintboot.pruebaJava.controller;

import com.prueba.java.sprintboot.pruebaJava.caseuse.*;
import com.prueba.java.sprintboot.pruebaJava.entity.House;
import com.prueba.java.sprintboot.pruebaJava.entity.Inscription;
import com.prueba.java.sprintboot.pruebaJava.repository.InscriptionRepository;
import com.prueba.java.sprintboot.pruebaJava.service.InscriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inscriptions")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class InscriptionsController {
    private GetInscription getInscription;
    private GetHouse getHouse;
    private InscriptionRepository inscriptionRepository;
    private InscriptionService inscriptionService;
    private CreateInscription createInscription;
    private DeleteInscription deleteInscription;
    private UpdateInscription updateInscription;

    public InscriptionsController(
            GetInscription getInscription,
            GetHouse getHouse,
            InscriptionRepository inscriptionRepository,
            InscriptionService inscriptionService,
            CreateInscription createInscription,
            DeleteInscription deleteInscription,
            UpdateInscription updateInscription
    ) {
        this.getInscription = getInscription;
        this.getHouse = getHouse;
        this.inscriptionRepository = inscriptionRepository;
        this.inscriptionService = inscriptionService;
        this.createInscription = createInscription;
        this.deleteInscription = deleteInscription;
        this.updateInscription = updateInscription;
    }

    @GetMapping("/")
    List<Inscription> get(){
        return getInscription.getAll();
    }

    @PostMapping("/")
    ResponseEntity<Inscription> newInscription(@RequestBody Inscription newInscription){
        System.out.println(getInscription.getAll());
        return new ResponseEntity<>(createInscription.save(newInscription), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteInscription(@PathVariable Long id){
        deleteInscription.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<Inscription> replaceUser(@RequestBody Inscription newInscription, @PathVariable Long id){
        return new ResponseEntity<>(updateInscription.update(newInscription, id), HttpStatus.OK);
    }


    @GetMapping("/pageable")
    ResponseEntity<Map<String, Object>> getUserPageable(@RequestParam int page, @RequestParam int size){
        try {
            List<Inscription> inscriptions = new ArrayList<Inscription>();
            Page<Inscription> inscriptionPage = inscriptionRepository.findAll(PageRequest.of(page - 1,size));
            inscriptions = inscriptionPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", inscriptions);
            response.put("per_page", inscriptionPage.getNumber() + 1);
            response.put("total", inscriptionPage.getTotalElements());
            response.put("last_page", inscriptionPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/houses")
    List<House> getHouses(){
        return getHouse.getAll();
    }

}
