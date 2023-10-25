package com.pichincha.Transaccion.Service;

import com.pichincha.Transaccion.DTOs.ClienteDTO;
import com.pichincha.Transaccion.DTOs.CuentaDTO;
import com.pichincha.Transaccion.Exception.BadRequestException;
import com.pichincha.Transaccion.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Value("${usuarios.request.url}")
    private String uri;
    public ClienteDTO getDataCliente(String clienteId) throws BadRequestException, NotFoundException {
        RestTemplate restTemplate = new RestTemplate();

        ClienteDTO response = restTemplate.getForObject(uri+clienteId, ClienteDTO.class);
        if (response==null){
            throw new NotFoundException("No Existe el usuario");
        }
        return response;
    }
}