package com.formula1.vencedoresformula1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VitoriasPorPaisDTO {
	
	private String pais;
	private String vitorias;
	
	@Override
	public String toString() {
		return "Piloto{" +
                "pais='" + pais + '\'' +
                "vitorias='" + vitorias + '\'' +
                '}';
	}

}
