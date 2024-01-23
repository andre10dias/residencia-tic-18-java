package Model;

import java.util.Date;
import java.util.Objects;

import Util.ConversaoDeDatasUtil;

public class Embarque {
	
	private Passageiro passageiro;
    private PontoParada pontoDeEmbarque;
    private String tipoCartao;
    private Date dataHora;
    
    public Embarque() {}
    
	public Embarque(Passageiro passageiro, PontoParada pontoDeEmbarque, String tipoCartao, Date dataHora) {
		this.passageiro = passageiro;
		this.pontoDeEmbarque = pontoDeEmbarque;
		this.tipoCartao = tipoCartao;
		this.dataHora = dataHora;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public PontoParada getPontoDeEmbarque() {
		return pontoDeEmbarque;
	}

	public void setPontoDeEmbarque(PontoParada pontoDeEmbarque) {
		this.pontoDeEmbarque = pontoDeEmbarque;
	}

	public String getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getDataHoraFormatada() {
		return ConversaoDeDatasUtil.dateToString(this.dataHora);
	}

	@Override
	public String toString() {
		return "Embarque{" +
                "passageiro='" + passageiro + '\'' +
                "pontoDeEmbarque='" + pontoDeEmbarque + '\'' +
                "tipoCartao='" + tipoCartao + '\'' +
                "dataHora='" + dataHora + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHora, passageiro, pontoDeEmbarque, tipoCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Embarque other = (Embarque) obj;
		return Objects.equals(dataHora, other.dataHora) && Objects.equals(passageiro, other.passageiro)
				&& Objects.equals(pontoDeEmbarque, other.pontoDeEmbarque)
				&& Objects.equals(tipoCartao, other.tipoCartao);
	}

}
