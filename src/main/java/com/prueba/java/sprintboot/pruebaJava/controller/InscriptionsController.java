package com.prueba.java.sprintboot.pruebaJava.controller;

import com.prueba.java.sprintboot.pruebaJava.caseuse.GetInscription;
import com.prueba.java.sprintboot.pruebaJava.entity.Inscription;
import com.prueba.java.sprintboot.pruebaJava.repository.InscriptionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionsController {
    private GetInscription getInscription;
    /*private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private InscriptionRepository inscriptionRepository;*/


    public InscriptionsController(
            /*GetInscription getInscription,
            CreateUser createUser,
            DeleteUser deleteUser,
            UpdateUser updateUser,
            InscriptionRepository inscriptionRepository*/
    ) {
        /*this.getInscription = getInscription;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.inscriptionRepository = inscriptionRepository;*/
    }

    /*@GetMapping("/")
    List<Inscription> get(){
        return getInscription.getAll();
        //return inscriptionRepository.findAll();
    }*/

    /*@PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size){
        return userRepository.findAll(PageRequest.of(page,size)).getContent();
    }*/

}
