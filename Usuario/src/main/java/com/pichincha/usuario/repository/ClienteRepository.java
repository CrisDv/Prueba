package com.pichincha.usuario.repository;


import com.pichincha.usuario.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    ClienteEntity findByClienteId(Long cliente_Id);
    void deleteByClienteId(long cliente_Id);

    //ClienteEntity updateClienteEntityByClienteId(ClienteEntity cliente, long clienteId);
}
