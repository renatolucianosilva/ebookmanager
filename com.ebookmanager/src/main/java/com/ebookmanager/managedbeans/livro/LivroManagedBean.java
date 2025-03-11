package com.ebookmanager.managedbeans.livro;

import com.ebookmanager.mapper.LivroMapper;
import com.ebookmanager.model.Genero;
import com.ebookmanager.model.Livro;
import com.ebookmanager.request.livro.LivroPostRequest;
import com.ebookmanager.service.LivroService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Named
@RequestScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroManagedBean implements Serializable {

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

    @Inject
    private LivroService livroService;

    @Inject
    private LivroMapper Mapper;

    public void cadastrarLivro() {

        livroService.save(Mapper
                .livroPostRequestToLivro(new LivroPostRequest(
                        titulo, autor, editora, anoPublicacao, genero, true)));

    }


}
