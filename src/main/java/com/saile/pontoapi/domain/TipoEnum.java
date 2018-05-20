package com.saile.pontoapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoEnum {
    ENTRADA("Entrada"),
    SAIDA("Saída");

    @Getter
    private String descricao;
}
