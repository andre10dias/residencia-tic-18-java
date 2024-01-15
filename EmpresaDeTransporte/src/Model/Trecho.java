package Model;

import java.util.Objects;

public class Trecho {
	
	private Trajeto codigoTrajeto;
	private PontoParada origem;
    private PontoParada destino;
    private Integer intervaloEstimado;
    
//	public Trecho(PontoParada origem, PontoParada destino, Integer intervaloEstimado) {
//		this.origem = origem;
//		this.destino = destino;
//		this.intervaloEstimado = intervaloEstimado;
//	}
	
	public Trecho(Trajeto codigoTrajeto, PontoParada origem, PontoParada destino, Integer intervaloEstimado) {
		this.codigoTrajeto = codigoTrajeto;
		this.origem = origem;
		this.destino = destino;
		this.intervaloEstimado = intervaloEstimado;
	}

	public Trajeto getCodigoTrajeto() {
		return codigoTrajeto;
	}

	public void setCodigoTrajeto(Trajeto codigoTrajeto) {
		this.codigoTrajeto = codigoTrajeto;
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
				"codigoTrajeto='" + codigoTrajeto + '\'' +
                "origem='" + origem + '\'' +
                "destino='" + destino + '\'' +
                "intervaloEstimado='" + intervaloEstimado + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoTrajeto, destino, intervaloEstimado, origem);
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
		return Objects.equals(codigoTrajeto, other.codigoTrajeto) && Objects.equals(destino, other.destino)
				&& Objects.equals(intervaloEstimado, other.intervaloEstimado) && Objects.equals(origem, other.origem);
	}

}
