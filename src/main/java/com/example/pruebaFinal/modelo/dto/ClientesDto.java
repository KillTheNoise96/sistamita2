package com.example.pruebaFinal.modelo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ClientesDto {
    private Integer idCliente;
    private String primNombre;
    private String segNombre;
    private String primApellido;
    private String segApellido;
    private String genero;
    private Integer telefono;
}
