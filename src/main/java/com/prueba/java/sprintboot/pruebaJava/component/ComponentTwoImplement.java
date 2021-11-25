package com.prueba.java.sprintboot.pruebaJava.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar(){
        System.out.println("Hola mundo desde el componente 2!!");
    }
}
