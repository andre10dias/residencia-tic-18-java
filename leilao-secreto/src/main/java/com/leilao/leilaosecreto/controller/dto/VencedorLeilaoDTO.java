package com.leilao.leilaosecreto.controller.dto;

import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.model.Leilao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VencedorLeilaoDTO {
	private Leilao leilao;
	private Double maiorValorLance;
	private Concorrente vencedor;

}
