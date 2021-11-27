package com.prueba.java.sprintboot.pruebaJava.service;

import com.prueba.java.sprintboot.pruebaJava.entity.House;
import com.prueba.java.sprintboot.pruebaJava.repository.HouseRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HouseService {
    private final Log LOG = LogFactory.getLog(HouseService.class);
    private HouseRepository houseRepository;
    private HouseService houseService;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Transactional
    public void saveTransactional(List<House> houses){
        houses.stream()
                .peek(house -> LOG.info("Casa creada => " + house ))
                .forEach(houseRepository::save);
    }

    public List<House> getAllHouses(){
        return houseRepository.findAll();
    }

    public House save(House newHouse) {
        return houseRepository.save(newHouse);
    }

    public void delete(Long id) {
        houseRepository.delete(new House(id));
    }

    public House update(House newHouse, Long id) {
        return houseRepository.findById(id)
                .map(
                        house -> {
                            house.setName(newHouse.getName());
                            return houseRepository.save(house);
                        }
                ).get();
    }
}
