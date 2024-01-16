package Model;

import java.util.Objects;

public class Trecho {
	
	private Integer codigo;
	private PontoParada origem;
    private PontoParada destino;
    private Integer intervaloEstimado;
	
	public Trecho() {}
	
	public Trecho(Integer codigo) {
		this.codigo = codigo;
	}

	public Trecho(Integer codigo, PontoParada origem, PontoParada destino, Integer intervaloEstimado) {
		this.codigo = codigo;
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

	public PontoParada getOrigem() {
		return origem;
	}
	
	public void setOrigem(PontoParada origem) {
		this.origem = origem;
	}
	
	public PontoParada getDestino() {
		return destino;
	}
	
	public void setDestino(PontoParada destino) {
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
		return "Trecho{" +
				"codigo='" + codigo + '\'' +
                "origem='" + origem + '\'' +
                "destino='" + destino + '\'' +
                "intervaloEstimado='" + intervaloEstimado + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, destino, intervaloEstimado, origem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trecho other = (Trecho) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(destino, other.destino)
				&& Objects.equals(intervaloEstimado, other.intervaloEstimado) && Objects.equals(origem, other.origem);
	}

}
