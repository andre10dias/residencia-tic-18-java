package com.leilao.leilaosecreto.controller.dto;

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
public class ConcorrenteDTO {
	private Long id;
	private String nome;
	private String cpf;

}
