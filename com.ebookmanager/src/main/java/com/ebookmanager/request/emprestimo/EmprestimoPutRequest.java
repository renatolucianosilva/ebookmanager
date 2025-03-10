package com.ebookmanager.request.emprestimo;

import com.ebookmanager.request.livro.LivroPutRequest;
import com.ebookmanager.request.usuario.UsuarioPutRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoPutRequest {


    private Long idEmprestimo;

    private LivroPutRequest livro;

    private UsuarioPutRequest usuario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataEmprestimo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDevolucaoPrevista;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDevolucao;

    private Double multa;

    private Boolean devolucao;




}
