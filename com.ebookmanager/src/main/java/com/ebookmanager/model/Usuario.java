package com.ebookmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name="adplencia")
    private Boolean adplencia;


}
