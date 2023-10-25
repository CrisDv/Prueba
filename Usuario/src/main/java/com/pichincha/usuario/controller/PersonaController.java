package com.pichincha.usuario.controller;

import com.pichincha.usuario.entity.ClienteEntity;
import com.pichincha.usuario.exception.NotFoundException;
import com.pichincha.usuario.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class PersonaController {
    @Autowired
    ClienteService service;

    @GetMapping("/obtenercliente/{id}")
    public ResponseEntity<ClienteEntity> getCliente(@PathVariable long id) throws NotFoundException {
        return new ResponseEntity<>(service.obtenerCliente(id), HttpStatus.OK);
    }

    @PostMapping("/crearcliente")
    public ResponseEntity<ClienteEntity> crearCliente(@RequestBody ClienteEntity cliente){
        return new ResponseEntity<>(service.crearCliente(cliente), HttpStatus.OK);
    }

    @PutMapping("/modificarcliente")
    public ResponseEntity<ClienteEntity> modificarCliente(@RequestBody ClienteEntity cliente) throws NotFoundException {
        return new ResponseEntity<>(service.modificarCliente(cliente), HttpStatus.OK);
    }


    @DeleteMapping("/eliminarcliente/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable(value = "id") long id) throws NotFoundException {
        service.eliminarCliente(id);
        return new ResponseEntity<>("Usuario Eliminado", HttpStatus.OK);
    }

}
