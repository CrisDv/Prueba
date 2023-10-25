package com.pichincha.Transaccion.Controller;

import com.pichincha.Transaccion.Entity.CuentaEntity;
import com.pichincha.Transaccion.Exception.BadRequestException;
import com.pichincha.Transaccion.Service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaCrud {

    @Autowired
    CuentaService service;

    @GetMapping("/obtenerCuenta/{id}")
    public ResponseEntity<CuentaEntity> getCuenta(@PathVariable long id) throws BadRequestException {
        return new ResponseEntity<>(service.obtenerCuenta(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/crearCuenta")
    public ResponseEntity<CuentaEntity> crearCuenta(@RequestBody CuentaEntity cuenta){
        return new ResponseEntity<>(service.crearCuenta(cuenta), HttpStatus.OK);
    }

    @PutMapping("/modificarCuenta")
    public ResponseEntity<String> modificarCuenta(){
        return new ResponseEntity<>("asdad", HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/eliminarCuenta")
    public ResponseEntity<String> eliminarCuenta(){
        return new ResponseEntity<>("asdad", HttpStatus.ACCEPTED);
    }
}
