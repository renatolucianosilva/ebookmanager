package com.ebookmanager.controller;

import com.ebookmanager.mapper.UsuarioMapper;
import com.ebookmanager.request.usuario.UsuarioPostRequest;
import com.ebookmanager.request.usuario.UsuarioPutRequest;
import com.ebookmanager.response.usuario.UsuarioGetResponse;
import com.ebookmanager.response.usuario.UsuarioPostResponse;
import com.ebookmanager.response.usuario.UsuarioPutResponse;
import com.ebookmanager.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioMapper Mapper;

    @PostMapping
    public ResponseEntity<UsuarioPostResponse> createUsuario(@RequestBody @Valid UsuarioPostRequest usuario) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Mapper.toPostResponse(usuarioService.save(Mapper.toUsuario(usuario))));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioGetResponse>> todosUsuario() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(Mapper.toGetResponse(usuarioService.findAll()));


    }

    @DeleteMapping("{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    @PutMapping
    public ResponseEntity<UsuarioPutResponse> updateUsuario(@RequestBody @Valid UsuarioPutRequest usuario) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(Mapper.toUsuarioPutResponse(usuarioService
                        .updateUsuario(Mapper.toUsuario(usuario))));
    }


}
