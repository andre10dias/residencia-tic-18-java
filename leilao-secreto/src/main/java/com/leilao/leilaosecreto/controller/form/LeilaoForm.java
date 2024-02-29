package com.leilao.leilaosecreto.controller.form;

import com.leilao.leilaosecreto.model.Leilao;
import com.leilao.leilaosecreto.repository.LeilaoRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeilaoForm {
	private String descricao;
	private Double valorMinimo;
	private String status;
	
	public Leilao toLeilao() {
		return new Leilao(null, descricao, valorMinimo, status, null);
	}
	
	public Leilao atualizar(Long id, LeilaoRepository repository) {
		Leilao leilao = repository.getReferenceById(id);
		leilao.setDescricao(this.descricao);
		leilao.setValorMinimo(this.valorMinimo);
		leilao.setStatus(this.status);
		
		return leilao;
	}
}


