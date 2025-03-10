package com.ebookmanager.request.emprestimo;

import com.ebookmanager.model.Emprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoPostRequest {


    private Long idLivro;

    private Long idUsuario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataEmprestimo;

    private Boolean devolucao;






}
