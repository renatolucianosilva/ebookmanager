package com.ebookmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_emprestimos")
@DynamicUpdate
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Long idEmprestimo;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "livro")
    private Livro livro;

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "data_emprestimo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEmprestimo;

    @Column(name = "devolucao_prevista")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "data_devolucao")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDevolucao;

    @Column(name = "id_usuario")
    private Double multa;

}
