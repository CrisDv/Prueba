package com.pichincha.Transaccion.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class CuentaDTO {
    private int NoCuenta;
    private String TipoCuenta;
    private int Saldo;
    private boolean estado;
    private Collection<MovimientoDTO> movimientos;
}
