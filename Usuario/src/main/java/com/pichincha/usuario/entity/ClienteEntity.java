package com.pichincha.usuario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "clienteId"), name = "Cliente")
public class ClienteEntity extends Personaclass {


    @Column(name = "clienteId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    private String pass;
    private boolean estado;
}
