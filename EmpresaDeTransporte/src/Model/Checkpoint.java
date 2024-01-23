package Model;

import java.util.Date;
import java.util.Objects;

import Util.ConversaoDeDatasUtil;

public class Checkpoint {
	
	private Trajeto trajeto;
    private PontoParada pontoDeParada;
    private Date dataHoraChegada;
    
    public Checkpoint() {}
	
	public Checkpoint(Trajeto trajeto, PontoParada pontoDeParada, Date dataHoraChegada) {
		this.trajeto = trajeto;
		this.pontoDeParada = pontoDeParada;
		this.dataHoraChegada = dataHoraChegada;
	}

	public Trajeto getTrajeto() {
		return trajeto;
	}

	public void setTrajeto(Trajeto trajeto) {
		this.trajeto = trajeto;
	}
	
	public PontoParada getPontoDeParada() {
		return pontoDeParada;
	}

	public void setPontoDeParada(PontoParada pontoDeParada) {
		this.pontoDeParada = pontoDeParada;
	}

	public Date getDataHoraChegada() {
		return dataHoraChegada;
	}

	public void setDataHoraChegada(Date dataHoraChegada) {
		this.dataHoraChegada = dataHoraChegada;
	}
	
	public String getDataHoraFormatada() {
		return ConversaoDeDatasUtil.dateToString(this.dataHoraChegada);
	}

	@Override
	public String toString() {
		return "Checkpoint{" +
                "trajeto='" + trajeto + '\'' +
                "pontoDeParada='" + pontoDeParada + '\'' +
                "dataHoraChegada='" + dataHoraChegada + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHoraChegada, pontoDeParada, trajeto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checkpoint other = (Checkpoint) obj;
		return Objects.equals(dataHoraChegada, other.dataHoraChegada)
				&& Objects.equals(pontoDeParada, other.pontoDeParada) && Objects.equals(trajeto, other.trajeto);
	}

}
