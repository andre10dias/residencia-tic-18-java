package com.leilao.leilaosecreto.controller.form;

import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.model.Lance;
import com.leilao.leilaosecreto.model.Leilao;
import com.leilao.leilaosecreto.repository.LanceRepository;

public class LanceForm {
	private Leilao leilao;
	private Concorrente concorrente;
	private Double valor;
	
	public Lance toLance() {
		return new Lance(null, leilao, concorrente, valor);
	}
	
	public Lance atualizar(Long id, LanceRepository repository) {
		com.leilao.leilaosecreto.model.Lance lance = repository.getReferenceById(id);
		lance.setLeilao(this.leilao);
		lance.setConcorrente(this.concorrente);
		lance.setValor(this.valor);
		
		return lance;
	}
}
