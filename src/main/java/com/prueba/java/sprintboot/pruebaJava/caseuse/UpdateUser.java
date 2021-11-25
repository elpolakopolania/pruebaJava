package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.entity.User;
import com.prueba.java.sprintboot.pruebaJava.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService){
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
         return userService.update(newUser, id);
    }
}
