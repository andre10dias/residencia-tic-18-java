package com.leilao.leilaosecreto.controller.dto;

import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.model.Leilao;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class LanceDTO {
	private Long id;
	private Leilao leilao;
	private Concorrente concorrente;
	private Double valor;

}
