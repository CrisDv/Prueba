package com.pichincha.Usuario.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@MappedSuperclass
public class PersonaEntity {

    //@SequenceGenerator(name = "Client_seq",sequenceName = "Cliente",initialValue = 1,allocationSize = 1)
    @UuidGenerator
    private String id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private int telefono;
}
