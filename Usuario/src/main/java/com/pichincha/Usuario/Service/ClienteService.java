package com.pichincha.Usuario.Service;

import com.pichincha.Usuario.Entity.ClienteEntity;
import com.pichincha.Usuario.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ClienteEntity crearCliente(ClienteEntity cliente){

        return clienteRepository.save(cliente);
    }

    public ClienteEntity obtenerCliente(long id){
        return clienteRepository.findByClienteId(id);
    }

    public void eliminarCliente(long id){
         clienteRepository.deleteByClienteId(id);
    }
}