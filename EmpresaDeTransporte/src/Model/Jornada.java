package Model;

import java.util.Date;
import java.util.Objects;

import Util.ConversaoDeDatasUtil;

public class Jornada {
	
	private Integer codigo;
	private Date inicio;
    private Date fim;
    private Trajeto trajeto;
    private MotoristaCobrador motoristaCobrador;
    private Veiculo veiculo;
    
	public Jornada(Integer codigo, Date inicio, Trajeto trajeto, Veiculo veiculo) {
		this.codigo = codigo;
		this.inicio = inicio;
		this.trajeto = trajeto;
		this.veiculo = veiculo;
	}

	public Jornada(Integer codigo, Date inicio, Date fim, Trajeto trajeto, Veiculo veiculo) {
		this.codigo = codigo;
		this.inicio = inicio;
		this.fim = fim;
		this.trajeto = trajeto;
		this.veiculo = veiculo;
	}

	public Jornada(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		if (this.inicio != null) {			
			return ConversaoDeDatasUtil.dateToString(this.inicio);
		}
		
		return "";
	}
	
	public String getDataFimFormatada() {
		if (this.fim != null) {
			return ConversaoDeDatasUtil.dateToString(this.fim);
		}
		
		return "";
	}

	@Override
	public String toString() {
		return "Jornada{" +
                "codigo='" + codigo + '\'' +
                "inicio='" + inicio + '\'' +
                "fim='" + fim + '\'' +
                "trajeto='" + trajeto + '\'' +
                "veiculo='" + veiculo + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(inicio, trajeto, veiculo);
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
		return Objects.equals(inicio, other.inicio) && Objects.equals(trajeto, other.trajeto) 
				&& Objects.equals(veiculo, other.veiculo);
	}

}
