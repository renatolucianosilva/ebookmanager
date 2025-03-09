package com.ebookmanager.response.usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UsuarioGetResponse {

    private Long idUsuario;
    private String nome;
    private String email;
    private String telefone;
    private boolean adplencia;

}
