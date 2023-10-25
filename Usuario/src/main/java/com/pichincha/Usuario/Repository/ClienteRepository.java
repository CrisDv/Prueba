package com.pichincha.Usuario.Repository;


import com.pichincha.Usuario.Entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    ClienteEntity findByClienteId(Long cliente_Id);
    void deleteByClienteId(long cliente_Id);
}
