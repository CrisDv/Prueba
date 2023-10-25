package com.pichincha.Transaccion.Service;

import com.pichincha.Transaccion.DTOs.ClienteDTO;
import com.pichincha.Transaccion.DTOs.CuentaDTO;
import com.pichincha.Transaccion.DTOs.MovimientoDTO;
import com.pichincha.Transaccion.Entity.CuentaEntity;
import com.pichincha.Transaccion.Entity.MovimientoEntity;
import com.pichincha.Transaccion.Exception.BadRequestException;
import com.pichincha.Transaccion.Exception.NotFoundException;
import com.pichincha.Transaccion.Repository.CuentaRepository;
import com.pichincha.Transaccion.Repository.MovimientoRepository;
import com.pichincha.Transaccion.Utils.UtilsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MovimientoRepository movimientoRepository;
    @Autowired
    ApiService apiService;


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


    public ClienteDTO clienteReporte(Date fechaInicio, Date fechaFinal, long clienteId) throws BadRequestException, NotFoundException {
        UtilsMapper utilsMapper=new UtilsMapper();


        ClienteDTO cliente=apiService.getDataCliente(String.valueOf(clienteId));


        List<CuentaEntity> cuentas=cuentaRepository.findAllByClienteId(clienteId);
        List<CuentaDTO> cuentasDto=new ArrayList<>();
        cuentas.forEach(cuenta -> cuentasDto.add(utilsMapper.mapCuentasToDTO(cuenta)));

        for (int i=0;i<cuentas.size();i++){
            List<MovimientoDTO> movimientoDTO=new ArrayList<>();
            List<MovimientoEntity> movimientoEntityList=new ArrayList<>();
            movimientoEntityList=movimientoRepository.findAllByCuentaAndFechaBetween(cuentas.get(i), fechaInicio, fechaFinal);
            movimientoEntityList.forEach(movimiento -> movimientoDTO.add(utilsMapper.mapMovimientoToDto(movimiento)));
            cuentasDto.get(i).setMovimientos(movimientoDTO);
        }
        cliente.setCuentas(cuentasDto);

        return cliente;
    }

    public void modificarCuenta(long idCuenta, CuentaEntity cuenta){
        cuentaRepository.
    }
}
