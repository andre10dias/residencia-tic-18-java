package com.leilao.leilaosecreto.controller.dto;

import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.model.Lance;
import com.leilao.leilaosecreto.model.Leilao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanceDTO {
	private Long id;
	private Leilao leilao;
	private Concorrente concorrente;
	private Double valor;
	
	public LanceDTO(Lance lance) {
		this.id = lance.getId();
		this.leilao = lance.getLeilao();
		this.concorrente = lance.getConcorrente();
	}

}
