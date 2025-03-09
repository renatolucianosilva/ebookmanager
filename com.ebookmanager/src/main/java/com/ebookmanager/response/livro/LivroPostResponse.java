package com.ebookmanager.response.livro;

import com.ebookmanager.model.Genero;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LivroPostResponse {

    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private Genero genero;
    private Boolean disponivel;
}
