package com.ebookmanager.service;

import com.ebookmanager.exceptions.BadRequestException;
import com.ebookmanager.mapper.EmprestimoMapper;
import com.ebookmanager.model.Emprestimo;
import com.ebookmanager.repository.EmprestimoRepository;
import com.ebookmanager.request.emprestimo.EmprestimoPostRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private EmprestimoMapper Mapper;

    private EmprestimoRepository repository;

    private LivroService livroService;

    private UsuarioService usuarioService;


    public Emprestimo create(EmprestimoPostRequest emprestimo) {

        return repository.save(novoEmprestimo(emprestimo));
    }

    public List<Emprestimo> listaEmprestimos(Boolean condicao) {

        return condicao != null ? repository.findByDevolucao(condicao) : repository.findAll();
    }

    public Emprestimo findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Id Emprestimo Not Found"));

    }


    public Emprestimo novoEmprestimo(EmprestimoPostRequest emprestimo) {

        var emprestimoNew = Mapper.toEmprestimo(emprestimo);

        emprestimoNew.selecionaUsuario(usuarioService.findById(emprestimo.getIdUsuario()));
        emprestimoNew.selecionaLivro(livroService.findById(emprestimo.getIdLivro()));

        return emprestimoNew.novoEmprestimo(emprestimoNew);
    }


    public void devolverLivro(Long id) {

        var livro = livroService.findById(id);
        livro.setDisponivel(true);

    }
}
