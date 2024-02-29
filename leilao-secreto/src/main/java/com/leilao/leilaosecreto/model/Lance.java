package com.leilao.leilaosecreto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Lance {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_leilao", referencedColumnName = "id", nullable = false)
	private Leilao leilao;
	
	@ManyToOne
	@JoinColumn(name = "id_concorrente", referencedColumnName = "id", nullable = false)
	private Concorrente concorrente;
	
	private Double valor;

}
