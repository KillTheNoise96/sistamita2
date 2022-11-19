package com.example.pruebaFinal.servicio;

import com.example.pruebaFinal.modelo.dto.ClientesDto;
import com.example.pruebaFinal.modelo.entity.Clientes;
import com.example.pruebaFinal.repo.crud.ClientesCrud;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ClientesService {

    @Value("${user}")
    private String usuario;

    @Value("${pass}")
    private String clave;

    private ClientesCrud clientesCrud;

    @Autowired
    public ClientesService(ClientesCrud clientesCrud) {
        this.clientesCrud = clientesCrud;
    }

    public List<Clientes> obtenerListaClientes() {
        return (List<Clientes>) clientesCrud.findAll();
    }

    public void guardar(Clientes clientes) {
        clientesCrud.save(clientes);
    }

    public List<ClientesDto> obtenerDatosApi() {
        String api = "http://localhost:8090/produccion/clientes/lista";
        RestTemplate rest = new RestTemplate();
        rest.getInterceptors().add(new BasicAuthenticationInterceptor(usuario, clave));
        ClientesDto[] array = rest.getForObject(api, ClientesDto[].class);
        return Arrays.asList(array);
    }
}
