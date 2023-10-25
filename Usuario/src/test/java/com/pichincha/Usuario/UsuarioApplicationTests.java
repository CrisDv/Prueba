package com.pichincha.Usuario;

import com.pichincha.Usuario.Entity.ClienteEntity;
import com.pichincha.Usuario.Service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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

        Assert.
    }

}
