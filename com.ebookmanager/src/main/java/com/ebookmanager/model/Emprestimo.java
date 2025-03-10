package com.ebookmanager.model;

import com.ebookmanager.exceptions.BadRequestException;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    @Column(name = "devolucao")
    private Boolean devolucao;

    public Emprestimo novoEmprestimo(Emprestimo emprestimo) {
        this.livro = emprestimo.livro;
        if (!livro.isDisponivel()) throw new BadRequestException("Livro Indisponivel");
        livro.updateDisponivel("EMPRESTIMO");
        this.usuario = emprestimo.usuario;
        this.dataEmprestimo = emprestimo.dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista(dataEmprestimo);
        this.multa = 0.0;
        this.devolucao = false;

        return this;
    }

    public Emprestimo devolucao(Emprestimo emprestimo){
        emprestimo.livro.updateDisponivel("DEVOLUCAO");

        emprestimo.multa = calculaMulta(emprestimo);

        emprestimo.devolucao = true;

        emprestimo.dataDevolucao = LocalDate.now();

        return emprestimo;
    }

    public LocalDate dataDevolucaoPrevista(LocalDate date) {

        return date.plusDays(15L);

    }

    public Usuario selecionaUsuario(Usuario usuario) {
        return this.usuario = usuario;
    }

    public Livro selecionaLivro(Livro livro) {
        return this.livro = livro;
    }

    public Double calculaMulta(Emprestimo emprestimo) {

        double MULTA_POR_DIA = 1.5;
        double diasAtrasados = emprestimo.dataDevolucaoPrevista
                .until(LocalDate.now(), ChronoUnit.DAYS);
        if ( diasAtrasados <= 10) return 0.0;

        emprestimo.usuario.atualizaAdplencia(false);

        return diasAtrasados * MULTA_POR_DIA;


    }



}
