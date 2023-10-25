package com.pichincha.transaccion.service;

import com.pichincha.transaccion.dtos.ClienteDTO;
import com.pichincha.transaccion.dtos.CuentaDTO;
import com.pichincha.transaccion.dtos.MovimientoDTO;
import com.pichincha.transaccion.entity.CuentaEntity;
import com.pichincha.transaccion.entity.MovimientoEntity;
import com.pichincha.transaccion.exception.BadRequestException;
import com.pichincha.transaccion.exception.NotFoundException;
import com.pichincha.transaccion.repository.CuentaRepository;
import com.pichincha.transaccion.repository.MovimientoRepository;
import com.pichincha.transaccion.utils.UtilsMapper;
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

    }

    public boolean eliminarCuenta(long id){
        boolean a=cuentaRepository.deleteByClienteId(id);
        return a;
    }
}
