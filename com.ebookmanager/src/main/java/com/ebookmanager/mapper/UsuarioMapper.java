package com.ebookmanager.mapper;

import com.ebookmanager.model.Livro;
import com.ebookmanager.model.Usuario;
import com.ebookmanager.request.livro.LivroPostRequest;
import com.ebookmanager.request.livro.LivroPutRequest;
import com.ebookmanager.request.usuario.UsuarioPostRequest;
import com.ebookmanager.request.usuario.UsuarioPutRequest;
import com.ebookmanager.response.livro.LivroGetResponse;
import com.ebookmanager.response.livro.LivroPostResponse;
import com.ebookmanager.response.livro.LivroPutResponse;
import com.ebookmanager.response.usuario.UsuarioGetResponse;
import com.ebookmanager.response.usuario.UsuarioPostResponse;
import com.ebookmanager.response.usuario.UsuarioPutResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {


    Usuario toUsuario(UsuarioPostRequest usuario);

    Usuario toUsuario(UsuarioPutRequest usuario);

    UsuarioPutResponse toUsuarioPutResponse(Usuario usuario);

    UsuarioPostResponse toPostResponse(Usuario usuario);

    List<UsuarioGetResponse> toGetResponse(List<Usuario> usuarios);







}
