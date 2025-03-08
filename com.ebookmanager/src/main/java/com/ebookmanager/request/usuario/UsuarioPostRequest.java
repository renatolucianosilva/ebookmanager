package com.ebookmanager.request.usuario;

import com.ebookmanager.model.Genero;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UsuarioPostRequest {

    @NotNull(message = "Campo Título Obrigatorio")
    @NotEmpty(message = "Campo Título Obrigatorio")
    private String nome;

    @NotNull(message = "Campo Autor Obrigatorio")
    @NotEmpty(message = "Campo Autor Obrigatorio")
    private String email;

    @NotNull(message = "Campo Autor Obrigatorio")
    @NotEmpty(message = "Campo Autor Obrigatorio")
    private String telefone;

    private boolean adplencia;

}
