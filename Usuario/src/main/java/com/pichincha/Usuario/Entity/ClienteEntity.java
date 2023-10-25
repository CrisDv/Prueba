package com.pichincha.Usuario.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "Cliente")
public class ClienteEntity extends PersonaEntity {


    @Column(name = "clienteId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    private String pass;
    private boolean estado;
}
