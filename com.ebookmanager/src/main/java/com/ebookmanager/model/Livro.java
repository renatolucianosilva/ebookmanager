package com.ebookmanager.model;

import com.ebookmanager.exceptions.BadRequestException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_livros")
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name="editora")
    private String editora;

    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;

    @Column(name = "genero")
    @Enumerated
    private Genero genero;

    @Column(name = "disponivel")
    private Boolean disponivel;

    public void updateDisponivel(String operacao) {

        if (!disponivel) throw new BadRequestException("Livro Indisponivel");

        if(operacao.equals("EMPRESTIMO")) this.disponivel = false;

        if(operacao.equals("DEVOLUCAO")) this.disponivel = true;



    }



}
