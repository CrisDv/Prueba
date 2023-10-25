package com.pichincha.usuario.service;

import com.pichincha.usuario.entity.ClienteEntity;
import com.pichincha.usuario.exception.NotFoundException;
import com.pichincha.usuario.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ClienteEntity crearCliente(ClienteEntity cliente){
        cliente.setIdentificacion(UUID.randomUUID().toString().substring(0, 13));
        return clienteRepository.save(cliente);
    }

    public ClienteEntity obtenerCliente(long id) throws NotFoundException {
        ClienteEntity cliente=clienteRepository.findByClienteId(id);
        if (cliente==null){
            throw new NotFoundException("No se encontro el usuario");
        }
        return cliente;
    }

    public ClienteEntity modificarCliente(ClienteEntity cliente) throws NotFoundException {
        ClienteEntity cliente1=obtenerCliente(cliente.getClienteId());
        cliente1.setNombre(cliente.getNombre());
        cliente1.setEdad(cliente.getEdad());
        cliente1.setGenero(cliente.getGenero());
        cliente1.setEstado(cliente.isEstado());
        cliente1.setTelefono(cliente.getTelefono());
        cliente1.setIdentificacion(cliente.getIdentificacion());
        cliente1.setPass(cliente.getPass());

        return clienteRepository.save(cliente1);
    }

    public void eliminarCliente(long id) throws NotFoundException {
        this.obtenerCliente(id);
         clienteRepository.deleteByClienteId(id);

    }
}
