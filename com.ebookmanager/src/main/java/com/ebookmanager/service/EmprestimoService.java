package com.ebookmanager.service;

import com.ebookmanager.exceptions.BadRequestException;
import com.ebookmanager.model.Emprestimo;
import com.ebookmanager.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private EmprestimoRepository repository;

    private LivroService livroService;

    private UsuarioService usuarioService;

    public Emprestimo criateEmprestimo(Emprestimo emprestimo, Long idLivro, Long user) {

        emprestimo.setLivro(livroService.verificaLivroDisponivel(idLivro));
        emprestimo.getLivro().setDisponivel(false);


        emprestimo.setUsuario(usuarioService.findById(user));

        return repository.save(emprestimo);

    }

}
