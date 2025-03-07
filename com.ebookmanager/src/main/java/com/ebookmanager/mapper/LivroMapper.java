package com.ebookmanager.mapper;

import com.ebookmanager.model.Livro;
import com.ebookmanager.request.LivroPostRequest;
import com.ebookmanager.response.LivroGetResponse;
import com.ebookmanager.response.LivroPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LivroMapper {


    Livro livroPostRequestToLivro(LivroPostRequest livroPostResquest);


    LivroPostResponse livroPostResponseToLivro(Livro livro);

    List<LivroGetResponse>  listBooksToListBookGetResponse(List<Livro> livros);

}
