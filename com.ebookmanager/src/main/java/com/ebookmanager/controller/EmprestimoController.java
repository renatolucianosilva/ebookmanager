package com.ebookmanager.controller;

import com.ebookmanager.mapper.EmprestimoMapper;
import com.ebookmanager.model.Emprestimo;
import com.ebookmanager.repository.EmprestimoRepository;
import com.ebookmanager.request.emprestimo.EmprestimoPostRequest;
import com.ebookmanager.response.emprestimo.EmprestimoGetResponse;
import com.ebookmanager.response.emprestimo.EmprestimoPostResponse;
import com.ebookmanager.service.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/emprestimos")
@AllArgsConstructor
public class EmprestimoController {

    private EmprestimoMapper Mapper;

    private EmprestimoService service;

   @PostMapping
   public ResponseEntity<EmprestimoPostResponse> createEmprestimo(@RequestBody EmprestimoPostRequest emprestimoRequest) {

       return ResponseEntity.status(HttpStatus.CREATED)
               .body(Mapper.toEmprestimoResponse(service.create(Mapper.toEmprestimo(emprestimoRequest), emprestimoRequest)));

   }

   @GetMapping
    public ResponseEntity<List<EmprestimoGetResponse>> retornaEmprestimos() {

       return  ResponseEntity.status(HttpStatus.OK)
               .body(Mapper.toListEmprestimoResponse(service.listaEmprestimos()));

   }

}
