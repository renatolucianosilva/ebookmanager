package com.ebookmanager.response;

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
    private String genero;
}
