package com.pichincha.Transaccion.Repository;

import com.pichincha.Transaccion.Entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    Optional<CuentaEntity> findByNoCuenta(long NoCuenta);


}