package com.ebookmanager.mapper;

import com.ebookmanager.model.Emprestimo;
import com.ebookmanager.request.emprestimo.EmprestimoPostRequest;
import com.ebookmanager.request.emprestimo.EmprestimoPutRequest;
import com.ebookmanager.response.emprestimo.EmprestimoGetResponse;
import com.ebookmanager.response.emprestimo.EmprestimoPostResponse;
import com.ebookmanager.response.emprestimo.EmprestimoPutResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmprestimoMapper {

    Emprestimo toEmprestimo(EmprestimoPostRequest emprestimo);

    Emprestimo toEmprestimo(EmprestimoPutRequest emprestimo);

    EmprestimoPutResponse toEmprestimoPutResponse(Emprestimo emprestimo);

    EmprestimoPostResponse toEmprestimoResponse(Emprestimo emprestimo);

    List<EmprestimoGetResponse> toListEmprestimoResponse(List<Emprestimo> emprestimos);

    EmprestimoGetResponse toEmprestimoGetResponse(Emprestimo emprestimo);
}
