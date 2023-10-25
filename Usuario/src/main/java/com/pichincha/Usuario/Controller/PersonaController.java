package com.pichincha.Usuario.Controller;

import com.pichincha.Usuario.Entity.ClienteEntity;
import com.pichincha.Usuario.Service.ClienteService;
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
    public ResponseEntity<ClienteEntity> getCliente(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerCliente(id), HttpStatus.OK);
    }

    @PostMapping("/crearcliente")
    public ResponseEntity<ClienteEntity> crearCliente(@RequestBody ClienteEntity cliente){
        return new ResponseEntity<>(service.crearCliente(cliente), HttpStatus.OK);
    }

    @PutMapping("/modificarcliente")
    public ResponseEntity<String> modificarCliente(){
        return new ResponseEntity<>("asdad", HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/eliminarcliente")
    public ResponseEntity<String> eliminarCliente(@PathVariable long id){
        service.eliminarCliente(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

}
