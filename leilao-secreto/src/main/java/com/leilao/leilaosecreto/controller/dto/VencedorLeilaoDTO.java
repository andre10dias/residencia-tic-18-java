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
	
	public VencedorLeilaoDTO(Leilao leilao) {
		this.leilao = leilao;
		this.maiorValorLance = leilao.getListaLances().get(0).getValor();
		this.vencedor = leilao.getListaLances().get(0).getConcorrente();
	}

}
