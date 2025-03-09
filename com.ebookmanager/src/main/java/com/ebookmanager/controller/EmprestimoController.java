package com.ebookmanager.controller;

import com.ebookmanager.mapper.EmprestimoMapper;
import com.ebookmanager.model.Emprestimo;
import com.ebookmanager.repository.EmprestimoRepository;
import com.ebookmanager.request.emprestimo.EmprestimoPostRequest;
import com.ebookmanager.response.emprestimo.EmprestimoPostResponse;
import com.ebookmanager.service.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/emprestimos")
@AllArgsConstructor
public class EmprestimoController {

    private EmprestimoMapper Mapper;

    private EmprestimoService service;

   @PostMapping(value = "{livro}/{user}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmprestimoPostResponse> create(@RequestBody EmprestimoPostRequest emprestimoRequest, @PathVariable Long livro, @PathVariable Long user) {

       return ResponseEntity.status(HttpStatus.CREATED)
                .body(Mapper.toEmprestimoResponse(service.criateEmprestimo(Mapper.toEmprestimo(emprestimoRequest), livro, user)));
   }


}
