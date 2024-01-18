package DTO;

public class TrechoDTO {
	
	private Integer codigo;
	private String origem;
    private String destino;
    private Integer intervaloEstimado;
    
	public TrechoDTO() {}

	public TrechoDTO(Integer codigo, String origem, String destino, Integer intervaloEstimado) {
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.intervaloEstimado = intervaloEstimado;
	}
	
	public TrechoDTO(String origem, String destino, Integer intervaloEstimado) {
		this.origem = origem;
		this.destino = destino;
		this.intervaloEstimado = intervaloEstimado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getIntervaloEstimado() {
		return intervaloEstimado;
	}

	public void setIntervaloEstimado(Integer intervaloEstimado) {
		this.intervaloEstimado = intervaloEstimado;
	}

	@Override
	public String toString() {
		return origem + ", " + destino + ", " + intervaloEstimado;
	}
    
}
