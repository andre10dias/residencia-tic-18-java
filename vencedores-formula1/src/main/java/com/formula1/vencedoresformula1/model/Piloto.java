package com.formula1.vencedoresformula1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pilotos")
public class Piloto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pais;
	private String piloto;
	private Integer vitorias;
	
	public Piloto(String pais, String piloto, Integer vitorias) {
		this.pais = pais;
		this.piloto = piloto;
		this.vitorias = vitorias;
	}
	
	@Override
	public String toString() {
		return "Piloto{" +
                "pais='" + pais + '\'' +
                "piloto='" + piloto + '\'' +
                "vitorias='" + vitorias + '\'' +
                '}';
	}

}
