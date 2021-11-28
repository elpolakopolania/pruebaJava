package com.prueba.java.sprintboot.pruebaJava;

import com.prueba.java.sprintboot.pruebaJava.entity.House;
import com.prueba.java.sprintboot.pruebaJava.service.HouseService;
import com.prueba.java.sprintboot.pruebaJava.service.InscriptionService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PruebaJavaApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(PruebaJavaApplication.class);

	private InscriptionService inscriptionService;
	private HouseService houseService;

	public PruebaJavaApplication(
			InscriptionService inscriptionService,
			HouseService houseService
	){
		this.inscriptionService = inscriptionService;
		this.houseService = houseService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PruebaJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.createHouse();
	}

	private void createHouse(){
		House home1 = new House("Gryffindor");
		House home2 = new House("Hufflepuff");
		House home3 = new House("Ravenclaw");
		House home4 = new House("Slytherin");

		List<House> houses = Arrays.asList(home1, home2, home3, home4);
		try {
			houseService.saveTransactional(houses);
		}catch(Exception e){
			LOGGER.error("Esta es una exception dentro del metodo transaccional =>" + e);
		}

		houseService.getAllHouses().stream()
				.forEach(house -> LOGGER.info("Casa creada => " + house));
	}

}
