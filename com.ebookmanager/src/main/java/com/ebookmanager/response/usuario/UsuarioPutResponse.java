package com.ebookmanager.response.usuario;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UsuarioPutResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private boolean adplencia;

}
