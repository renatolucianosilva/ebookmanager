package com.ebookmanager.service;

import com.ebookmanager.exceptions.BadRequestException;
import com.ebookmanager.model.Genero;
import com.ebookmanager.model.Livro;
import com.ebookmanager.repository.LivroRepository;
import com.ebookmanager.request.LivroPutRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro findById(Long id){
        return livroRepository.findById(id).orElseThrow(() -> new BadRequestException("ID not Found"));
    }

    public List<Livro> findAll(){

       var livros = livroRepository.findAll();

       if(livros.isEmpty()) throw new BadRequestException("Not Found Livros");

       return livros;

    }

    public List<Livro> findByTitle(String title){
        var livros = livroRepository.findByTitulo(title);

        if(livros.isEmpty()) throw new BadRequestException("Title Not Found");

        return livros;

    }

    public void delete(Long id){
        var livro = findById(id);
        livroRepository.delete(livro);
    }

    public Livro updateBook(Livro livro)  {
        findById(livro.getId());
        return livroRepository.save(livro);



    }

    public List<Livro> findByAutor(String autor){
        var livros = livroRepository.findByAutor(autor);

        if(livros.isEmpty()) throw new BadRequestException("Autor Not Found");

        return livros;

    }


}
