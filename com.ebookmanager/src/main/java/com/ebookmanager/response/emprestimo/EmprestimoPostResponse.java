package com.ebookmanager.response.emprestimo;

import com.ebookmanager.model.Livro;
import com.ebookmanager.model.Usuario;
import com.ebookmanager.response.livro.LivroPostResponse;
import com.ebookmanager.response.usuario.UsuarioPostResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmprestimoPostResponse {

    private long idEmprestimo;

    private LivroPostResponse livro;

    private UsuarioPostResponse usuario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataEmprestimo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDevolucaoPrevista;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDevolucao;

    private Double multa;

    private Boolean devolucao;
}
