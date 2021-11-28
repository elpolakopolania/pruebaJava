package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.entity.House;
import com.prueba.java.sprintboot.pruebaJava.service.HouseService;

import java.util.List;

public class GetHouseImplement implements  GetHouse{
    private HouseService houseService;

    public GetHouseImplement(HouseService houseService){
        this.houseService = houseService;
    }

    @Override
    public List<House> getAll() {
        return houseService.getAllHouses();
    }
}
