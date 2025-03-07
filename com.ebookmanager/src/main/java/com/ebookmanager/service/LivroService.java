package com.ebookmanager.service;

import com.ebookmanager.model.Livro;
import com.ebookmanager.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> findAll(){

        return livroRepository.findAll();

    }

    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }
}
