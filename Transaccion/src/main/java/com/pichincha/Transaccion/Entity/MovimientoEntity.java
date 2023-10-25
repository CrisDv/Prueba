package com.pichincha.Transaccion.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "movimiento")
public class MovimientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date fecha;
    private String tipoMovimiento;
    private int valor;
    private int saldo;

    //private int noCuenta;

    @ManyToOne
    @JoinColumn(name = "noCuenta")
    private CuentaEntity cuenta;

}
