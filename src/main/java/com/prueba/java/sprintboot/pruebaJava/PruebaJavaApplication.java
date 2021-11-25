package com.prueba.java.sprintboot.pruebaJava;

import com.prueba.java.sprintboot.pruebaJava.bean.MyBean;
import com.prueba.java.sprintboot.pruebaJava.bean.MyBeanWithDependency;
import com.prueba.java.sprintboot.pruebaJava.bean.MyBeanWithProperties;
import com.prueba.java.sprintboot.pruebaJava.component.ComponentDependency;
import com.prueba.java.sprintboot.pruebaJava.entity.User;
import com.prueba.java.sprintboot.pruebaJava.pojo.UserPojo;
import com.prueba.java.sprintboot.pruebaJava.repository.UserRepository;
import com.prueba.java.sprintboot.pruebaJava.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PruebaJavaApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(PruebaJavaApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public PruebaJavaApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean, MyBeanWithDependency myBeanWithDependency,
			MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo,
			UserRepository userRepository,
			UserService userService
	){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PruebaJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.classesAnteriores();
		this.saveUserInDataBase();
		this.getInformationJpqlFromUser();
		this.saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("testTrans1", "testTrans1@gmail.com", LocalDate.now());
		User test2 = new User("testTrans2", "testTrans2@gmail.com", LocalDate.now());
		User test3 = new User("testTrans3", "testTrans3@gmail.com", LocalDate.now());
		User test4 = new User("testTrans4", "testTrans4@gmail.com", LocalDate.now());
		User test5 = new User("testTrans5", "testTrans5@gmail.com", LocalDate.now());

		List<User> users = Arrays.asList(test1, test2, test3, test4, test5);
		try {
			userService.saveTransactional(users);
		}catch(Exception e){
			LOGGER.error("Esta es una exception dentro del metodo transaccional =>" + e);
		}

		userService.getAllUsers().stream()
				.forEach(user -> LOGGER.info("Este es el usuario dentro del metodo transaccional" + user));

	}


	private void getInformationJpqlFromUser(){
		/*LOGGER.info("Usuario con el metodo findByUserEmail => " +
				userRepository.findByUserEmail("gustavo@email.com")
						.orElseThrow( ()-> new RuntimeException("No se encontró el usuario"))
		);

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("User like => " + user));

		userRepository.findByName("user")
				.stream()
				.forEach(user-> LOGGER.info("Usuario con query metodo => " + user));

		LOGGER.info("Usuario con query metodo Email name => " +
			userRepository.findByEmailAndName("gustavo@email.com", "Gustavo")
					.orElseThrow(()-> new RuntimeException("No se encontró el usuario"))
		);

		userRepository.findByNameLike("%e%")
				.stream()
				.forEach(user -> LOGGER.info("usuario findBYnameLIke " + user));

		userRepository.findByNameOrEmail("Lorena",null)
				.stream()
				.forEach(user -> LOGGER.info("usuario findByNameOrEmail " + user));


		userRepository.findByBirthDateBetween(LocalDate.of(2021,01,01), LocalDate.of(2021,12,01))
				.stream()
				.forEach(user -> LOGGER.info("usuario con intervalo de fechas " + user));

		userRepository.findByNameLikeOrderByIdDesc("%user%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado -> " + user));

		userRepository.findByNameLikeOrderByIdAsc("%user%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado -> " + user));

		userRepository.findByNameContainingOrderByIdDesc("user")
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado -> " + user));*/


		LOGGER.info("El usuario a partir del name parameter es: => " +
		userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021,04,20), "Daniela@email.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario del name parameter"))
		);



	}

	private void saveUserInDataBase(){
		User user1 = new User("Gustavo", "gustavo@email.com", LocalDate.of(2021,01,20));
		User user2 = new User("Adolfo", "Adolfo@email.com", LocalDate.of(2021,02,20));
		User user3 = new User("Andres", "Andres@email.com", LocalDate.of(2021,03,20));
		User user4 = new User("Daniela", "Daniela@email.com", LocalDate.of(2021,04,20));
		User user5 = new User("Camilo", "Camilo@email.com", LocalDate.of(2021,05,20));
		User user6 = new User("Arley", "Arley@email.com", LocalDate.of(2021,06,20));
		User user7 = new User("Carolina", "Carolina@email.com", LocalDate.of(2021,07,20));
		User user8 = new User("Naty", "Naty@email.com", LocalDate.of(2021,8,20));
		User user9 = new User("Mateo", "Mateo@email.com", LocalDate.of(2021,9,20));
		User user10 = new User("Jose", "Jose@email.com", LocalDate.of(2021,10,20));
		User user11 = new User("Lorena", "Lorena@email.com", LocalDate.of(2021,11,20));
		User user12 = new User("user1", "user1@email.com", LocalDate.of(2021,12,20));
		User user13 = new User("user2", "user2@email.com", LocalDate.of(2021,12,20));
		User user14 = new User("user3", "user3@email.com", LocalDate.of(2021,12,20));
		User user15 = new User("user4", "user4@email.com", LocalDate.of(2021,12,20));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12,user13,user14,user15);
		list.stream().forEach(userRepository::save);
	}

	private void classesAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());
		LOGGER.error("Esto es un error del aplicativo. prueba");
		/*try{
			int value = 10/0;
			LOGGER.info("Mi valor:" + value);
		}catch(Exception e) {
			LOGGER.error("Esto es un error al dividir por cero: " + e.getStackTrace());
		}*/
	}
}
