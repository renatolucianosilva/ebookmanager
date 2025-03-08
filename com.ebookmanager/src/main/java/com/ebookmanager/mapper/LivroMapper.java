package com.ebookmanager.mapper;

import com.ebookmanager.model.Livro;
import com.ebookmanager.request.livro.LivroPostRequest;
import com.ebookmanager.request.livro.LivroPutRequest;
import com.ebookmanager.response.livro.LivroGetResponse;
import com.ebookmanager.response.livro.LivroPostResponse;
import com.ebookmanager.response.livro.LivroPutResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LivroMapper {


    Livro livroPostRequestToLivro(LivroPostRequest livroPostResquest);

    Livro livroPutRequestToLivro(LivroPutRequest livroPutRequest);

    LivroGetResponse livroToLivroGetResponse(Livro livro);

    LivroPostResponse livroPostResponseToLivro(Livro livro);

    List<LivroGetResponse>  listBooksToListBookGetResponse(List<Livro> livros);

    LivroPutResponse livroToLivroPutResponse(Livro livro);



}
