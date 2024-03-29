package com.pichincha.transaccion.service;

import com.pichincha.transaccion.dtos.ClienteDTO;
import com.pichincha.transaccion.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Value("${usuarios.request.url}")
    private String uri;
    public ClienteDTO getDataCliente(String clienteId) throws NotFoundException {
        RestTemplate restTemplate = new RestTemplate();

        ClienteDTO response = restTemplate.getForObject(uri+clienteId, ClienteDTO.class);
        if (response==null){
            throw new NotFoundException("No Existe el usuario");
        }
        return response;
    }
}