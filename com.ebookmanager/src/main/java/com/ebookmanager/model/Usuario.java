package com.ebookmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "name")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name="adplencia")
    private Boolean adplencia;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_alunos", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_agendamento"))
    private List<Emprestimo> emprestimos;


}
