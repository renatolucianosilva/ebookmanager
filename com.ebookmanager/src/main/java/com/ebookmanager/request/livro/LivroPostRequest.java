package com.ebookmanager.request.livro;

import com.ebookmanager.model.Genero;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


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
    private Boolean disponivel = true;

    public LivroPostRequest(@NotNull(message = "Campo Título Obrigatorio") @NotEmpty(message = "Campo Título Obrigatorio") String titulo, @NotNull(message = "Campo Autor Obrigatorio") @NotEmpty(message = "Campo Autor Obrigatorio") String autor, String editora, Integer anoPublicacao, Genero genero, Boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponivel = disponivel;
    }
}
