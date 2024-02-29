package com.leilao.leilaosecreto.controller.form;

import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.model.Lance;
import com.leilao.leilaosecreto.model.Leilao;
import com.leilao.leilaosecreto.repository.LanceRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanceForm {
	private Leilao leilao;
	private Concorrente concorrente;
	private Double valor;
	
	public Lance toLance() {
		return new Lance(null, leilao, concorrente, valor);
	}
	
	public Lance atualizar(Long id, LanceRepository repository) {
		Lance lance = repository.getReferenceById(id);
		lance.setLeilao(this.leilao);
		lance.setConcorrente(this.concorrente);
		lance.setValor(this.valor);
		
		return lance;
	}
}
