package com.prueba.java.sprintboot.pruebaJava.caseuse;

import com.prueba.java.sprintboot.pruebaJava.entity.User;
import com.prueba.java.sprintboot.pruebaJava.service.UserService;

import java.util.List;

public class GetUserImplement implements  GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService){
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
