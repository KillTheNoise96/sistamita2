package com.example.pruebaFinal.vista;

import com.example.pruebaFinal.modelo.dto.ClientesDto;
import com.example.pruebaFinal.modelo.entity.Clientes;
import com.example.pruebaFinal.servicio.ClientesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@Data
@Scope("session")
public class ClientesBackBean implements Serializable {

    Clientes clientes;

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
    private String celular;

    List<Clientes> clientesList;

    List<ClientesDto> clientesApiList;

    ClientesService clientesService;

    @PostConstruct
    public void init() {
        cargarLista();
        cargarListaApi();
    }

    @Autowired
    public ClientesBackBean(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    public void limpiar() {
        clientes = null;
        primerNombre = null;
        segundoNombre = null;
        primerApellido = null;
        segundoApellido = null;
        sexo = null;
    }

    public void guardar() {
        clientes = new Clientes();
        clientes.setPrimerNombre(primerNombre);
        clientes.setSegundoNombre(segundoNombre);
        clientes.setPrimerApellido(primerApellido);
        clientes.setSegundoApellido(segundoApellido);
        clientes.setSexo(sexo);
        clientes.setCelular(1315566);
        clientesService.guardar(clientes);
        limpiar();
        cargarLista();
        cargarListaApi();
    }

    public void cargarLista() {
        clientesList = clientesService.obtenerListaClientes();
    }

    public void cargarListaApi() {
        clientesApiList = clientesService.obtenerDatosApi();
    }

}
