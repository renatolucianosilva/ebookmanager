package com.ebookmanager.service;

import com.ebookmanager.components.EmprestimoSetData;
import com.ebookmanager.exceptions.BadRequestException;
import com.ebookmanager.model.Emprestimo;
import com.ebookmanager.model.Livro;
import com.ebookmanager.model.Usuario;
import com.ebookmanager.repository.EmprestimoRepository;
import com.ebookmanager.request.emprestimo.EmprestimoPostRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private EmprestimoRepository repository;

    private LivroService livroService;

    private UsuarioService usuarioService;

    private EmprestimoSetData emprestimoSetData;


    public Emprestimo create(Emprestimo emprestimo, EmprestimoPostRequest emprestimoRequest) {

       return repository.save(realizarEmprestimo(emprestimo, emprestimoRequest));
    }

    public List<Emprestimo> listaEmprestimos() {
        return repository.findAll();
    }

    public Emprestimo realizarEmprestimo(Emprestimo emprestimo, EmprestimoPostRequest emprestimoRequest) {

        emprestimo.setLivro(selecionaLivro(emprestimoRequest.getIdLivro()));

        emprestimo.setUsuario(selecionaUsuario(emprestimoRequest.getIdUsuario()));

        emprestimo.setDataDevolucaoPrevista(emprestimoSetData.dataDevolucaoPrevista(emprestimo.getDataEmprestimo()));

        emprestimo.setMulta(emprestimoSetData.calculoMulta(emprestimo.getDataDevolucaoPrevista()));

        return emprestimo;
    }

    public Usuario selecionaUsuario(Long id){

        return usuarioService.findById(id);
    }

    public Livro selecionaLivro(Long id){

        return livroService.findById(id);
    }

}
