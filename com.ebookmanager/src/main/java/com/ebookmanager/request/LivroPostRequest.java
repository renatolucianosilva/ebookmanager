package com.ebookmanager.request;

import com.ebookmanager.model.Genero;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LivroPostRequest {

    @NotNull(message = "Campo Título Obrigatorio")
    @NotEmpty(message = "Campo Título Obrigatorio")
    private String titulo;

    @NotNull(message = "Campo Autor Obrigatorio")
    @NotEmpty(message = "Campo Autor Obrigatorio")
    private String autor;

    private String editora;
    private Integer anoPublicacao;
    private Genero genero;
    private Boolean disponivel;

}
