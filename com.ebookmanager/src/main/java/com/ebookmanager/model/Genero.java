package com.ebookmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public enum Genero {

    FICCAO("Ficção"),
    TECNICO("Técnico"),
    CIENTIFICO("Científico"),
    HISTORIA("História"),
    RELIGIAO("Religião");

    private final String GENERO;

    Genero(String GENERO) {
        this.GENERO = GENERO;
    }

    public String getGenero() {
        return GENERO;
    }



}
