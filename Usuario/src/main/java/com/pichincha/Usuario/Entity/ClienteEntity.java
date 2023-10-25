package com.pichincha.Usuario.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "clienteId"), name = "Cliente")
public class ClienteEntity extends PersonaEntity {


    @Column(name = "clienteId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    private String pass;
    private boolean estado;
}
