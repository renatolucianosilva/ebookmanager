package com.ebookmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tb_emprestimos")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Long idEmprestimo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_livro")
    private Livro livro;



    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Column(name = "data_emprestimo")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataEmprestimo;

    @Column(name = "devolucao_prevista")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "data_devolucao")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDevolucao;

    @Column(name = "multa")
    private Double multa;

}
