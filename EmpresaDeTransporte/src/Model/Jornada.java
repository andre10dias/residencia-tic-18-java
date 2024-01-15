package Model;

import java.util.Date;
import java.util.Objects;

import Util.EmpresaDeTransporteUtil;

public class Jornada {
	
	private Date inicio;
    private Date fim;
    private Trajeto trajeto;
    private MotoristaCobrador motoristaCobrador;
    private Veiculo veiculo;
    
	public Jornada(Date inicio, Trajeto trajeto, 
			MotoristaCobrador motoristaCobrador, Veiculo veiculo) {
		this.inicio = inicio;
		this.trajeto = trajeto;
		this.motoristaCobrador = motoristaCobrador;
		this.veiculo = veiculo;
	}

	public Jornada(Date inicio, Date fim, Trajeto trajeto, 
			MotoristaCobrador motoristaCobrador, Veiculo veiculo) {
		this.inicio = inicio;
		this.fim = fim;
		this.trajeto = trajeto;
		this.motoristaCobrador = motoristaCobrador;
		this.veiculo = veiculo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Trajeto getTrajeto() {
		return trajeto;
	}

	public void setTrajeto(Trajeto trajeto) {
		this.trajeto = trajeto;
	}

	public MotoristaCobrador getMotoristaCobrador() {
		return motoristaCobrador;
	}

	public void setMotoristaCobrador(MotoristaCobrador motoristaCobrador) {
		this.motoristaCobrador = motoristaCobrador;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public String getDataInicioFormatada() {
		return EmpresaDeTransporteUtil.dateToString(this.inicio);
	}
	
	public String getDataFimFormatada() {
		return EmpresaDeTransporteUtil.dateToString(this.fim);
	}

	@Override
	public String toString() {
		return "Veiculo{" +
                "inicio='" + inicio + '\'' +
                "fim='" + fim + '\'' +
                "trajeto='" + trajeto + '\'' +
                "motoristaCobrador='" + motoristaCobrador + '\'' +
                "veiculo='" + veiculo + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(inicio, motoristaCobrador, trajeto, veiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jornada other = (Jornada) obj;
		return Objects.equals(inicio, other.inicio) && Objects.equals(motoristaCobrador, other.motoristaCobrador)
				&& Objects.equals(trajeto, other.trajeto) && Objects.equals(veiculo, other.veiculo);
	}

}
