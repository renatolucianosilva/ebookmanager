package com.ebookmanager.components;

import com.ebookmanager.request.emprestimo.EmprestimoPostRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class EmprestimoSetData {

    private final Double valorMulta = 2.0;
    private Double valorPagar;

    public LocalDate dataDevolucaoPrevista(LocalDate date) {

        return date.plusDays(10L);

    }

    public Double calculoMulta(LocalDate datePrevista) {

        var dias = datePrevista.until(LocalDate.now(), ChronoUnit.DAYS);

        if (dias > 0) {

            return this.valorPagar = this.valorMulta * dias;

        }

        return this.valorPagar = 0.0;

    }
}
