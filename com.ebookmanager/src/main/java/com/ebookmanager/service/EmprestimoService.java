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

import java.time.LocalDate;
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

    public List<Emprestimo> listaEmprestimos(Boolean condicao) {

        return condicao != null ? repository.findByDevolucao(condicao) : repository.findAll();
    }

    public Emprestimo findById(Long id) {

        return repository.findById(id)
                .orElseThrow( () -> new BadRequestException("Id Emprestimo Not Found"));

    }

    public Emprestimo devolucao(Long id) {

        return calcularMulta(findById(id));
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

        var livro =  livroService.findById(id);
        livro.setDisponivel(false);
        return livro;

    }

    public void devolverLivro(Long id){

        var livro =  livroService.findById(id);
        livro.setDisponivel(true);

    }

    public Emprestimo calcularMulta(Emprestimo emprestimo){

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setMulta(emprestimoSetData.calculoMulta(emprestimo.getDataDevolucao()));
        emprestimo.setDevolucao(true);
        devolverLivro(emprestimo.getLivro().getId());

        return repository.save(emprestimo);


    }

}
