package com.prueba.java.sprintboot.pruebaJava.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    MyOperation myOperation;
    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency(){
        int numero= 10;
        LOGGER.info("Error desde info: Desde MyBeanWithDependencyImplement");
        LOGGER.debug("Debbug desde:Desde MyBeanWithDependencyImplement" + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implenentacion de un bean con dependencia");
    }
}
