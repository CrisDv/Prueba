package com.pichincha.usuario;

import com.pichincha.usuario.entity.ClienteEntity;
import com.pichincha.usuario.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuarioApplicationTests {
    @Autowired
    ClienteService clienteService;
    @Test
    public void testObtenerClientes(){
        ClienteEntity cliente=new ClienteEntity();
        cliente.setClienteId(Long.valueOf(123456));
        cliente.setIdentificacion("12Mock");
        cliente.setPass("password");
        cliente.setEstado(true);
        cliente.setGenero("Masculino");
        cliente.setEdad(23);
        cliente.setNombre("Fulano");


    }

}
