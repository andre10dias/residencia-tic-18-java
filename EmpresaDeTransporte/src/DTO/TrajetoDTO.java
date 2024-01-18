package DTO;

import java.util.ArrayList;
import java.util.List;

public class TrajetoDTO {
	
	private Integer codigo;
	private List<TrechoDTO> trechos;
	
	public TrajetoDTO() {}

	public TrajetoDTO(Integer codigo) {
		this.codigo = codigo;
		this.trechos = new ArrayList<>();
	}

	public TrajetoDTO(Integer codigo, List<TrechoDTO> trechos) {
		this.codigo = codigo;
		this.trechos = trechos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<TrechoDTO> getListaTrechosDto() {
		return trechos;
	}

	public void setListaTrechosDto(List<TrechoDTO> trechos) {
		this.trechos = trechos;
	}

	@Override
	public String toString() {
		return "codigo=" + codigo + ", trechos=" + trechos;
	}

}
