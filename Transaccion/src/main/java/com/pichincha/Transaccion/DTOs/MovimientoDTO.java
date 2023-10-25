package com.pichincha.Transaccion.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class MovimientoDTO {
    private Long id;
    private Date fecha;
    private String tipoMovimiento;
    private int valor;


}
