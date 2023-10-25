package com.pichincha.Transaccion.Utils;

import com.pichincha.Transaccion.DTOs.CuentaDTO;
import com.pichincha.Transaccion.DTOs.MovimientoDTO;
import com.pichincha.Transaccion.Entity.CuentaEntity;
import com.pichincha.Transaccion.Entity.MovimientoEntity;

import java.util.Date;

public class UtilsMapper {

    public String reformatDate(Date officialDate){
        return "";
    }

    public CuentaDTO mapCuentasToDTO(CuentaEntity cuenta){
        CuentaDTO cuentaDTO=new CuentaDTO();
        cuentaDTO.setNoCuenta(cuenta.getNoCuenta());
        cuentaDTO.setSaldo(cuenta.getSaldo());
        cuentaDTO.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaDTO.setEstado(cuenta.isEstado());
        return cuentaDTO;
    }

    public MovimientoDTO mapMovimientoToDto(MovimientoEntity movimientoEntity){
        MovimientoDTO movimientoDTO=new MovimientoDTO();
        movimientoDTO.setId(movimientoDTO.getId());
        movimientoDTO.setTipoMovimiento(movimientoEntity.getTipoMovimiento());
        movimientoDTO.setFecha(movimientoEntity.getFecha());
        movimientoDTO.setValor(movimientoDTO.getValor());
        return movimientoDTO;
    }
}
