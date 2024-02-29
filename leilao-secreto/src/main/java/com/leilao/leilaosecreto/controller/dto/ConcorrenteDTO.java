package com.leilao.leilaosecreto.controller.dto;

import com.leilao.leilaosecreto.model.Concorrente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConcorrenteDTO {
	private Long id;
	private String nome;
	private String cpf;
	
	public ConcorrenteDTO(Concorrente concorrente) {
		this.id = concorrente.getId();
		this.nome = concorrente.getNome();
		this.cpf = concorrente.getCpf();
	}

}
