package com.pichincha.Transaccion.DTOs;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@JsonPropertyOrder({"noCuenta", "tipoCuenta", "saldo", "estado", "Movimientos"})
public class CuentaDTO {
    private Long NoCuenta;
    private String TipoCuenta;
    private int Saldo;
    private boolean estado;
    private List<MovimientoDTO> Movimientos;
}
