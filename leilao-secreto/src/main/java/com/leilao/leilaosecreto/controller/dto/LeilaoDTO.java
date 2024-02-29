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
public class LeilaoDTO {
	private Long id;
	private String descricao;
	private Double valorMinimo;
	private String status;

}
