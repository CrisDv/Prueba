package com.pichincha.Transaccion.Service;

import com.pichincha.Transaccion.Entity.CuentaEntity;
import com.pichincha.Transaccion.Exception.BadRequestException;
import com.pichincha.Transaccion.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    public CuentaEntity obtenerCuenta(long NumeroCuenta) throws BadRequestException {
        Optional<CuentaEntity> cuentaOptional=cuentaRepository.findByNoCuenta(NumeroCuenta);

        if (cuentaOptional.isEmpty()){
            throw new BadRequestException("No Se encontro una cuenta con el numero: "+String.valueOf(NumeroCuenta));
        }
        //CuentaEntity cuenta=cuentaOptional.get();
        return cuentaRepository.findByNoCuenta(NumeroCuenta).get();
    }

    public CuentaEntity crearCuenta(CuentaEntity cuenta){
        return cuentaRepository.save(cuenta);
    }
}
