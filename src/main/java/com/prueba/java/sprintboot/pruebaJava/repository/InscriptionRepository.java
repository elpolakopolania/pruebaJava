package com.prueba.java.sprintboot.pruebaJava.repository;

import com.prueba.java.sprintboot.pruebaJava.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, Long> {
    List<Inscription> findAll();
}
