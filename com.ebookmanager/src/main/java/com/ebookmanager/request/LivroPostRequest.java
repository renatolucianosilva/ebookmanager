package com.ebookmanager.request;

import com.ebookmanager.model.Genero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroPostRequest {


    private String titulo;
    private String autor;
    private String editora;
    private Integer anoPublicacao;
    private Genero genero;
    private Boolean disponivel;

}
