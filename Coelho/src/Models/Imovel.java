package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
	private Cliente cliente
	
	@Column(unique = true, nullable = false)
	private String matricula;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(name = "leituraAnterior")
	private Double leituraAnterior;
	
	@Column(name = "leituraAnterior")
	private Double leituraAtual;

	public Imovel() {
		// TODO Auto-generated constructor stub
	}

	public Imovel(String matricula, String endereco) {
		this.matricula = matricula;
		this.endereco = endereco;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(Double leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public Double getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(Double leituraAtual) {
		this.leituraAtual = leituraAtual;
	}
	
	@Override
	public String toString() {
		return this.matricula + "\t" + this.endereco;
	}

}
