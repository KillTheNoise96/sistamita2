package com.example.pruebaFinal.vista;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
@Data
@Scope("session")
public class SinSeguridad implements Serializable {

    private String hola = "Probando si llega...";

    @PostConstruct
    public void init() {
        System.out.println("Hola, que hace?");
    }
}


