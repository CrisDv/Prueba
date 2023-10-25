package com.pichincha.usuario.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@MappedSuperclass
public class Personaclass {

    //@SequenceGenerator(name = "Client_seq",sequenceName = "Cliente",initialValue = 1,allocationSize = 1)
    @UuidGenerator
    private String id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private int telefono;
}
