package com.leilao.leilaosecreto.controller.dto;

import com.leilao.leilaosecreto.model.Leilao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeilaoDTO {
	private Long id;
	private String descricao;
	private Double valorMinimo;
	private String status;
	
	public LeilaoDTO(Leilao leilao) {
		this.id = leilao.getId();
		this.descricao = leilao.getDescricao();
		this.valorMinimo = leilao.getValorMinimo();
		this.status = leilao.getStatus();
	}

}
