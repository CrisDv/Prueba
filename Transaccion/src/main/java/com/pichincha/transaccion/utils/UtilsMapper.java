package com.pichincha.transaccion.utils;

import com.pichincha.transaccion.dtos.CuentaDTO;
import com.pichincha.transaccion.dtos.MovimientoDTO;
import com.pichincha.transaccion.entity.CuentaEntity;
import com.pichincha.transaccion.entity.MovimientoEntity;

public class UtilsMapper {

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
