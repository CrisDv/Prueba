package com.pichincha.Transaccion.Repository;

import com.pichincha.Transaccion.Entity.MovimientoEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
}
