package com.ebookmanager.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroPostRequest {


    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String genero;

}
