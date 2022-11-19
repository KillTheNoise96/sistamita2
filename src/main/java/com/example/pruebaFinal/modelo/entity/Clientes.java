package com.example.pruebaFinal.modelo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CLIENTES_RONNY", schema = "dbo")
public class Clientes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "CELULAR")
    private Integer celular;
}
