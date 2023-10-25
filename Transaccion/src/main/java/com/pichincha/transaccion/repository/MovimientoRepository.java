package com.pichincha.transaccion.repository;

import com.pichincha.transaccion.entity.CuentaEntity;
import com.pichincha.transaccion.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    List<MovimientoEntity> findAllByCuentaAndFechaBetween(CuentaEntity noCuenta,Date starDate, Date endDate);
}
