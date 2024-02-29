package com.leilao.leilaosecreto.controller.form;

import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.repository.ConcorrenteRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConcorrenteForm {
	private String nome;
	private String cpf;
	
	public Concorrente toConcorrente() {
		return new Concorrente(null, nome, cpf);
	}
	
	public Concorrente atualizar(Long id, ConcorrenteRepository repository) {
		Concorrente concorrente = repository.getReferenceById(id);
		concorrente.setNome(this.nome);
		concorrente.setCpf(this.cpf);
		
		return concorrente;
	}
}