package com.pichincha.usuario.exception;


import com.pichincha.usuario.entity.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviseController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> HandleExceptions(Exception ex){
        ResponseEntity<ErrorDTO> response = null;
        ErrorDTO errorDTO=new ErrorDTO();


        if (ex instanceof NotFoundException){
            errorDTO.setId(HttpStatus.NOT_FOUND.value());
            errorDTO.setDescripcion(ex.getMessage());
            response=new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
