package com.formula1.vencedoresformula1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Piloto {
	
	private String pais;
	private String nome;
	private Integer vitorias;
	
	@Override
	public String toString() {
		return "Piloto{" +
                "pais='" + pais + '\'' +
                "nome='" + nome + '\'' +
                "vitorias='" + vitorias + '\'' +
                '}';
	}

}
