package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService){
        this.userService = userService;
    }

    public void remove(Long id) {
        userService.delete(id);
    }
}
