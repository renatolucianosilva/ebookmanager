package com.ebookmanager.request.emprestimo;

import com.ebookmanager.model.Livro;
import com.ebookmanager.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoPostRequest {




    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataEmprestimo;




}
