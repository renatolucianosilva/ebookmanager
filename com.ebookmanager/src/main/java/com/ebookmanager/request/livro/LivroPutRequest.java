package com.ebookmanager.request.livro;

import com.ebookmanager.model.Genero;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class LivroPutRequest {

    @NotNull(message = "Campo ID Obrigatorio")
    @NotEmpty(message = "Campo ID Obrigatorio")
    private Long id;

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
