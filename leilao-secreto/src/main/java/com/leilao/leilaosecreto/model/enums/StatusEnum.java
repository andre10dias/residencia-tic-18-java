package com.leilao.leilaosecreto.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	
	ABERTO(1, "Aberto"),
    FECHADO(2, "Fechado");

    private final Integer codigo;
    private final String descricao;

}
