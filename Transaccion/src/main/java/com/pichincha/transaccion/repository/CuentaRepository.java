package com.pichincha.transaccion.repository;

import com.pichincha.transaccion.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    Optional<CuentaEntity> findByNoCuenta(long NoCuenta);
    ArrayList<CuentaEntity> findAllByClienteId(long clienteId);

    boolean deleteByClienteId(long clienteId);

}
