package com.ebookmanager.controller;

import com.ebookmanager.mapper.LivroMapper;
import com.ebookmanager.model.Livro;
import com.ebookmanager.request.LivroPostRequest;
import com.ebookmanager.response.LivroGetResponse;
import com.ebookmanager.response.LivroPostResponse;
import com.ebookmanager.service.LivroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/livros")
@AllArgsConstructor
public class LivroController {

    private final LivroService livroService;

    private final LivroMapper Mapper;

    @PostMapping
    public ResponseEntity<LivroPostResponse> saveBook(@RequestBody @Valid LivroPostRequest livroRequest){

        var livro = Mapper.livroPostRequestToLivro(livroRequest);

        var livroSaved = livroService.save(livro);

        var livroResponse = Mapper.livroPostResponseToLivro(livroSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(livroResponse);
    }

    @GetMapping
    public ResponseEntity<List<LivroGetResponse>> allBooks(){

        var listLivros = livroService.findAll();

        var listLivrosGetResponse = Mapper.listBooksToListBookGetResponse(listLivros);

        return ResponseEntity.status(HttpStatus.OK).body(listLivrosGetResponse);


    }

}
