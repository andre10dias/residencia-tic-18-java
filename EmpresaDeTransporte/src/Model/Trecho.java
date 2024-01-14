package Model;

import java.util.Objects;

public class Trecho {
	
	private PontoParada origem;
    private PontoParada destino;
    private int intervaloEstimado;
    
	public Trecho(PontoParada origem, PontoParada destino, Integer intervaloEstimado) {
		this.origem = origem;
		this.destino = destino;
		this.intervaloEstimado = intervaloEstimado;
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
	
	public int getIntervaloEstimado() {
		return intervaloEstimado;
	}
	
	public void setIntervaloEstimado(Integer intervaloEstimado) {
		this.intervaloEstimado = intervaloEstimado;
	}

	@Override
	public String toString() {
		return "Trecho{" +
                "origem='" + origem + '\'' +
                "destino='" + destino + '\'' +
                "intervaloEstimado='" + intervaloEstimado + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, intervaloEstimado, origem);
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
		return Objects.equals(destino, other.destino) && intervaloEstimado == other.intervaloEstimado
				&& Objects.equals(origem, other.origem);
	}

}
