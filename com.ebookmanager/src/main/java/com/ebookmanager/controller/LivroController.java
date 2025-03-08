package com.ebookmanager.controller;

import com.ebookmanager.mapper.LivroMapper;
import com.ebookmanager.model.Livro;
import com.ebookmanager.request.LivroPostRequest;
import com.ebookmanager.request.LivroPutRequest;
import com.ebookmanager.response.LivroGetResponse;
import com.ebookmanager.response.LivroPostResponse;
import com.ebookmanager.response.LivroPutResponse;
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

    @GetMapping("{id}")
    public ResponseEntity<LivroGetResponse> findbyId(@PathVariable @Valid Long id){

        var livroGetResponse = Mapper.livroToLivroGetResponse(livroService.findById(id));

        return ResponseEntity.status(HttpStatus.OK).body(livroGetResponse);

    }

    @DeleteMapping({"{id}"})
    public void deleteBook(@PathVariable @Valid Long id){
        livroService.delete(id);
    }

    @PutMapping
    public ResponseEntity<LivroPutResponse> alterarLivro(@RequestBody LivroPutRequest livroRequest){

        var livro = Mapper.livroPutRequestToLivro(livroRequest);

        var livroUpdate = livroService.updateBook(livro);

        var livroPutResponse = Mapper.livroToLivroPutResponse(livroUpdate);

        return ResponseEntity.status(HttpStatus.OK).body(livroPutResponse);


    }


    @GetMapping("filterTitle")
    public ResponseEntity<List<LivroGetResponse>> findbyTitle(@RequestParam(defaultValue = "") String title){

        var listLivros = livroService.findByTitle(title);

        var listLivrosGetResponse = Mapper.listBooksToListBookGetResponse(listLivros);

        return ResponseEntity.status(HttpStatus.OK).body(listLivrosGetResponse);
    }

    @GetMapping("filterAutor")
    public ResponseEntity<List<LivroGetResponse>> findbyAutor(@RequestParam(defaultValue = "") String autor){

        var listAutor = livroService.findByAutor(autor);

        var listLivrosGetResponse = Mapper.listBooksToListBookGetResponse(listAutor);

        return ResponseEntity.status(HttpStatus.OK).body(listLivrosGetResponse);
    }

}
