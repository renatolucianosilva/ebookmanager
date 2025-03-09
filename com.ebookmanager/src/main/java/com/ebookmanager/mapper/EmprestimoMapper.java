package com.ebookmanager.mapper;

import com.ebookmanager.model.Emprestimo;
import com.ebookmanager.request.emprestimo.EmprestimoPostRequest;
import com.ebookmanager.response.emprestimo.EmprestimoPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmprestimoMapper {

    Emprestimo toEmprestimo(EmprestimoPostRequest empretimo);

    EmprestimoPostResponse toEmprestimoResponse(Emprestimo emprestimo);
}
