package com.prueba.java.sprintboot.pruebaJava.repository;

import com.prueba.java.sprintboot.pruebaJava.entity.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> {
    List<House> findAll();
}
