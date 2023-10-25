package com.pichincha.Transaccion.Repository;

import com.pichincha.Transaccion.DTOs.MovimientoDTO;
import com.pichincha.Transaccion.Entity.CuentaEntity;
import com.pichincha.Transaccion.Entity.MovimientoEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    List<MovimientoEntity> findAllByCuentaAndFechaBetween(CuentaEntity noCuenta,Date starDate, Date endDate);
}
